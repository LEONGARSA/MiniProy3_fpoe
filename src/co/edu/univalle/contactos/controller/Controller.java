/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.contactos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.univalle.contactos.model.Model;
import co.edu.univalle.contactos.util.Util;
import co.edu.univalle.contactos.view.View;
import co.edu.univalle.contactos.vo.Contacto;
import co.edu.univalle.contactos.vo.Telefono;

/**
 *
 * @author LAURA
 */
public class Controller implements ActionListener, MouseListener {
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void initialize() {
		view.btnAgregarDireccion.addActionListener(this);
		view.btnEliminarDireccion.addActionListener(this);
		view.btnAgregarTelefono.addActionListener(this);
		view.btnEliminarTelefono.addActionListener(this);
		view.btnGuardar.addActionListener(this);
		view.btnCancelar.addActionListener(this);
		view.btnSalir.addActionListener(this);
		view.btnBuscar.addActionListener(this);
		view.btnModificar.addActionListener(this);
		view.btnEliminar.addActionListener(this);
		view.tblConsulta.addMouseListener(this);
		
		//Evento de salir de la aplicación
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		
		//Evento filtrar teclas
		view.txtIdentificacion.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent event) {
	        	char keyPressed = event.getKeyChar();
	        	
				if (!((keyPressed >= '0') && (keyPressed <= '9') || (keyPressed == KeyEvent.VK_BACK_SPACE) || (keyPressed == KeyEvent.VK_DELETE))) { 
					event.consume();
				}
	        }
		});
		
		//Evento filtrar teclas
		view.txtNombres.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent event) {
	        	char keyPressed = event.getKeyChar();
	
	        	if (!(Character.isAlphabetic(keyPressed) || keyPressed == 32)) {
	        		event.consume();
	        	}
	        }
		});
		
		//Evento filtrar teclas
		view.txtApellidos.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent event) {
	        	char keyPressed = event.getKeyChar();
	
	        	if (!(Character.isAlphabetic(keyPressed) || keyPressed == 32)) {
	        		event.consume();
	        	}
	        }
		});
		
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == view.btnAgregarDireccion) {
			getTableModel(view.tblDirecciones).addRow(new Object[]{null});
		}
		
		if (event.getSource() == view.btnEliminarDireccion) {
			deleteSelectedRow(view.tblDirecciones);
		}
		
		if (event.getSource() == view.btnAgregarTelefono) {
			getTableModel(view.tblTelefonos).addRow(new Object[]{null, null});
		}
		
		if (event.getSource() == view.btnEliminarTelefono) {
			deleteSelectedRow(view.tblTelefonos);
		}
		
		if (event.getSource() == view.btnGuardar) {
			if (validate()) {
				//Los datos son válidos
				Contacto contacto = buildContacto();
				if (model.getContacto() == null) {
					//Debe guardar un contacto nuevo
					if (model.save(contacto) == null) {
						//El contacto ya existe
						JOptionPane.showMessageDialog(view, "El contacto con identificación "+ contacto.getIdentificacion().longValue() +" ya existe", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					//Debe modificar un contacto existente
					model.update(contacto);
				}
				
				model.findAll();
				updateView();
				clean();
			}
		}
		
		if (event.getSource() == view.btnCancelar) {
			model.findAll();
			clean();
		}
		
		if (event.getSource() == view.btnBuscar) {
			if (view.txtFiltroIdentificacion.getText().isBlank()) { //Filtro en blanco, busca todos los contactos
				model.findAll();
			} else {
				if (Util.isNumeric(view.txtFiltroIdentificacion.getText())) {
					model.findByIdentificacion(Long.parseLong(view.txtFiltroIdentificacion.getText()));
				} else {
					JOptionPane.showMessageDialog(view, "-Ingrese una identificación válida", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			updateView();
		}
		
		if (event.getSource() == view.btnModificar) {
			int selectedRow = view.tblConsulta.getSelectedRow();
			
			//System.out.println("Index =>");
			
			clean();
			view.setTitle("Contactos - Modificar");
			view.txtIdentificacion.setEnabled(false);
			view.btnCancelar.setText("Cancelar");
			
			Long identificacion = Long.parseLong(getTableModel(view.tblConsulta).getValueAt(selectedRow, 0).toString()); //Identificación
			model.loadContacto(identificacion);
			
			updateView();
		}
		
		if (event.getSource() == view.btnEliminar) {
			if (JOptionPane.showOptionDialog(view,
					"¿Desea eliminar este contacto?",
					"Eliminar", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					new String[]{"Sí", "No"},
					"default") == JOptionPane.OK_OPTION) {		            
				int selectedRow = view.tblConsulta.getSelectedRow();
				
				Long identificacion = Long.parseLong(getTableModel(view.tblConsulta).getValueAt(selectedRow, 0).toString()); //Identificación
				model.delete(identificacion);
				enableRowButtons(false);
				model.findAll();
				clean();
				updateView();
	        }
		}
		
		if (event.getSource() == view.btnSalir) {
			close();
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getSource() == view.tblConsulta) {
			if (view.tblConsulta.getSelectedRow() != -1) {
				//Debe habilitar los botones
				view.btnEliminar.setEnabled(true);
				view.btnModificar.setEnabled(true);
			} else {
				view.btnEliminar.setEnabled(false);
				view.btnModificar.setEnabled(false);
			}
		}
	}
	
	/**
	 * Valida obligatoriedad y formato de los campos
	 * @return
	 */
	private boolean validate() {
		boolean isValid = true;
		StringBuilder message = new StringBuilder();
		
		//Documento
		if (!Util.hasValidLength(view.txtIdentificacion.getText(), 11, true)) {
			//Length no válido
			message.append("-Ingrese una identificación de hasta 11 caracteres\n");
			isValid = false;
		} else if (!Util.isNumeric(view.txtIdentificacion.getText())) {
			//Tipo no válido
			message.append("-Ingrese una identificación válida\n");
			isValid = false;
		}
		
		//Nombres
		if (!Util.hasValidLength(view.txtNombres.getText(), 50, true)) {
			//Length no válido
			message.append("-Ingrese nombres de hasta 50 caracteres\n");
			isValid = false;
		} else if (!Util.isAlphabetic(view.txtNombres.getText())) {
			//Tipo no válido
			message.append("-Ingrese nombres válidos\n");
			isValid = false;
		}
		
		//Apellidos
		if (!Util.hasValidLength(view.txtApellidos.getText(), 50, true)) {
			//Length no válido
			message.append("-Ingrese apellidos de hasta 50 caracteres\n");
			isValid = false;
		} else if (!Util.isAlphabetic(view.txtApellidos.getText())) {
			//Tipo no válido
			message.append("-Ingrese apellidos válidos\n");
			isValid = false;
		}
		
		//Tipo contacto
		if (view.cmbTipoContacto.getSelectedIndex() == 0) {
			//No ha seleccionado un tipo de contacto
			message.append("-Seleccione un tipo de contacto\n");
			isValid = false;
		}
		
		//Fecha nacimiento
		if (view.dtpFechaNacimiento.getModel().getValue() == null) {
			//No ha seleccionado la fecha
			message.append("-Seleccione la fecha de nacimiento\n");
			isValid = false;
		}
		
		//Direcciones
		Vector<Vector> tblDireccionesData = getTableModel(view.tblDirecciones).getDataVector();
		if (tblDireccionesData.size() > 0) {
			for (Iterator iterator = tblDireccionesData.iterator(); iterator.hasNext();) {
				boolean isValidRow = true;
				Vector rowVector = (Vector) iterator.next();
				for (Object cell : rowVector) {
					if (!Util.hasValidLength(cell == null ? null : cell.toString(), 100, true)) {
						message.append("-Ingrese direcciones de hasta 100 caracteres\n");
						isValid = false;
						isValidRow = false;
						break;
					}
				}
				
				if (!isValidRow) break;
			}
		} else {
			message.append("-Agregue por lo menos una dirección\n");
			isValid = false;
		}
		
		//Telefonos
		Vector<Vector> tblTelefonosData = getTableModel(view.tblTelefonos).getDataVector();
		if (tblTelefonosData.size() > 0) {
			for (Iterator iterator = tblTelefonosData.iterator(); iterator.hasNext();) {
				boolean isValidRow = true;
				Vector rowVector = (Vector) iterator.next();
				
				if (!Util.hasValidLength(rowVector.get(0) == null ? null : rowVector.get(0).toString(), 10, true)) {
					//El teléfono no es válido
					message.append("-Agregue teléfonos de hasta 11 caracteres\n");
					isValid = false;
					isValidRow = false;
					break;
				} else if (!Util.isNumeric(rowVector.get(0) == null ? null : rowVector.get(0).toString())) {
					//El teléfono no es válido
					message.append("-Agregue teléfonos válidos\n");
					isValid = false;
					isValidRow = false;
					break;
				}
				
				if (!Util.hasValidLength(rowVector.get(1) == null ? null : rowVector.get(1).toString(), 50, true)) {
					//El teléfono no es válido
					message.append("-Agregue teléfonos con descripciones de hasta 50 caracteres\n");
					isValid = false;
					isValidRow = false;
					break;
				}
				
				if (!isValidRow) break;
			}
		} else {
			message.append("-Agregue por lo menos un teléfono\n");
			isValid = false;
		}
		
		if (!isValid) {
			JOptionPane.showMessageDialog(view, message.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return isValid;
	}
	
	/**
	 * Construye un VO con los datos en la UI
	 * @return
	 */
	private Contacto buildContacto() {
		Contacto contacto = new Contacto();
		contacto.setIdentificacion(Long.parseLong(view.txtIdentificacion.getText()));
		contacto.setNombres(view.txtNombres.getText());
		contacto.setApellidos(view.txtApellidos.getText());
		contacto.setTipoContacto(view.cmbTipoContacto.getSelectedItem().toString());
		contacto.setFechaNacimiento(((Calendar) view.dtpFechaNacimiento.getModel().getValue()).getTime());
		
		List<String> direcciones = new ArrayList<String>();
		Vector<Vector> tblDireccionesData = getTableModel(view.tblDirecciones).getDataVector();
		for (Iterator iterator = tblDireccionesData.iterator(); iterator.hasNext();) {
			Vector row = (Vector) iterator.next();
			for (Object cell : row) {
				direcciones.add(cell.toString());
			}
			
		}
		contacto.setDirecciones(direcciones);
		
		List<Telefono> telefonos = new ArrayList<Telefono>();
		Vector<Vector> tblTelefonosData = getTableModel(view.tblTelefonos).getDataVector();
		for (Iterator iterator = tblTelefonosData.iterator(); iterator.hasNext();) {
			Vector row = (Vector) iterator.next();
			Telefono telefono = new Telefono(row.get(0).toString(), row.get(1).toString());
			telefonos.add(telefono);
		}
		contacto.setTelefonos(telefonos);
		
		return contacto;
	}
	
	private DefaultTableModel getTableModel(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		return model;
	}
	
	private void deleteSelectedRow(JTable table) {
		int row = table.getSelectedRow();
		if (row >= 0) {
			getTableModel(table).removeRow(row);
		}
	}
	
	private void close() {
		if (JOptionPane.showOptionDialog(view,
				"¿Desea salir de la aplicación?",
				"Salir", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				new String[]{"Sí", "No"},
				"default") == JOptionPane.OK_OPTION) {		            
            System.exit(0);
        }
	}
	
	private void updateView() {
		
		//Actualiza la tabla de consulta
		List<Contacto> contactos = model.getContactos();
		getTableModel(view.tblConsulta).setRowCount(0);
		for (Contacto contactoBD : contactos) {
			getTableModel(view.tblConsulta).addRow(new Object[]{contactoBD.getIdentificacion(), contactoBD.getNombres(), contactoBD.getApellidos(), Util.dateToString(contactoBD.getFechaNacimiento()), contactoBD.getTipoContacto()});
		}
		
		//Carga los datos del contacto seleccionado
		if (model.getContacto() != null) {
			view.txtIdentificacion.setText(model.getContacto().getIdentificacion().toString());
			view.txtNombres.setText(model.getContacto().getNombres());
			view.txtApellidos.setText(model.getContacto().getApellidos());
			view.cmbTipoContacto.setSelectedItem(model.getContacto().getTipoContacto());
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(model.getContacto().getFechaNacimiento());
			view.dtpFechaNacimiento.getModel().setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
			view.dtpFechaNacimiento.getModel().setSelected(true);
			
			getTableModel(view.tblDirecciones).setRowCount(0);
			for (String direccion : model.getContacto().getDirecciones()) {
				getTableModel(view.tblDirecciones).addRow(new Object[]{ direccion });
			}
			
			getTableModel(view.tblTelefonos).setRowCount(0);
			
			for (Telefono telefono : model.getContacto().getTelefonos()) {
				getTableModel(view.tblTelefonos).addRow(new Object[]{ telefono.getNroTelefono(), telefono.getDescripcion() });
			}
		}
	}
	
	private void clean() {
		view.setTitle("Contactos");
		view.btnCancelar.setText("Limpiar");
		view.txtIdentificacion.setEnabled(true);
		view.txtIdentificacion.setText(null);
		view.txtNombres.setText(null);
		view.txtApellidos.setText(null);
		view.cmbTipoContacto.setSelectedIndex(0);
		view.dtpFechaNacimiento.getModel().setSelected(false);
		getTableModel(view.tblDirecciones).setRowCount(0);
		getTableModel(view.tblTelefonos).setRowCount(0);
		view.txtFiltroIdentificacion.setText(null);
		view.tblConsulta.clearSelection();
		enableRowButtons(false);
		
		model.setContacto(null);
	}
	
	private void enableRowButtons(boolean enable) {
		view.btnEliminar.setEnabled(enable);
		view.btnModificar.setEnabled(enable);
	}

	@Override
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mouseClicked(MouseEvent e) {}
}

