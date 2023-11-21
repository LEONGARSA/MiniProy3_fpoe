/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.contactos.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.jdatepicker.JDatePicker;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author LAURA
 */
public class View extends JFrame {
    
   	public JTextField txtFiltroIdentificacion;
	public JTextField txtIdentificacion;
	public JTextField txtNombres;
	public JTextField txtApellidos;
	public JTable tblDirecciones;
	public JTable tblTelefonos;
	public JTable tblConsulta;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnAgregarDireccion;
	public JButton btnEliminarDireccion;
	public JButton btnAgregarTelefono;
	public JButton btnEliminarTelefono;
	public JDatePicker dtpFechaNacimiento;
	public JComboBox<String> cmbTipoContacto;
	public JButton btnGuardar;
	public JButton btnCancelar;
	public JButton btnSalir;
        
public View() {
		initialize();
	}

	private void initialize() {
		setTitle("Contactos");
		setResizable(false);
		setBounds(0, 0, 633, 728);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationByPlatform(true);
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);
		this.getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
		
		JPanel pnlConsultar = new JPanel();
		pnlConsultar.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Consultar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		pnlConsultar.setBounds(10, 438, 598, 243);
		pnlPrincipal.add(pnlConsultar);
		pnlConsultar.setLayout(null);
		
		JLabel lblFiltroIdentificacion = new JLabel("Identificación:");
		lblFiltroIdentificacion.setBounds(61, 28, 113, 22);
		pnlConsultar.add(lblFiltroIdentificacion);
		
		txtFiltroIdentificacion = new JTextField();
		txtFiltroIdentificacion.setBounds(193, 28, 170, 22);
		pnlConsultar.add(txtFiltroIdentificacion);
		txtFiltroIdentificacion.setColumns(10);
		
                		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(437, 26, 100, 26);
		pnlConsultar.add(btnBuscar);
		
		JLabel lblIdentificacion = new JLabel("Identificación:");
		lblIdentificacion.setBounds(10, 12, 116, 22);
		pnlPrincipal.add(lblIdentificacion);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 46, 116, 22);
		pnlPrincipal.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(332, 46, 116, 22);
		pnlPrincipal.add(lblApellidos);
		
		JLabel lblTipoContacto = new JLabel("Tipo de contacto:");
		lblTipoContacto.setBounds(10, 80, 116, 26);
		pnlPrincipal.add(lblTipoContacto);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(332, 80, 116, 26);
		pnlPrincipal.add(lblFechaNacimiento);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(141, 12, 145, 22);
		pnlPrincipal.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(141, 46, 145, 22);
		pnlPrincipal.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(463, 46, 145, 22);
		pnlPrincipal.add(txtApellidos);
		
		JPanel pnlDirecciones = new JPanel();
		pnlDirecciones.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Direcciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		pnlDirecciones.setBounds(10, 122, 598, 108);
		pnlPrincipal.add(pnlDirecciones);
		pnlDirecciones.setLayout(null);
		
		JScrollPane scrDirecciones = new javax.swing.JScrollPane();
		scrDirecciones.setBounds(89, 26, 322, 64);
		pnlDirecciones.add(scrDirecciones);
		
		tblDirecciones = new JTable();
		tblDirecciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblDirecciones.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                ""
	            }
	        ));
		
		tblDirecciones.setTableHeader(null);
		
		scrDirecciones.setViewportView(tblDirecciones);
		
		btnAgregarDireccion = new JButton("+");
		btnAgregarDireccion.setToolTipText("Agrega una dirección");
		btnAgregarDireccion.setBounds(455, 26, 52, 26);
		pnlDirecciones.add(btnAgregarDireccion);
		
		btnEliminarDireccion = new JButton("-");
		btnEliminarDireccion.setToolTipText("Elimina la dirección seleccionada");
		btnEliminarDireccion.setBounds(455, 64, 52, 26);
		pnlDirecciones.add(btnEliminarDireccion);
		
		JPanel pnlTelefonos = new JPanel();
		pnlTelefonos.setLayout(null);
		pnlTelefonos.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tel\u00E9fonos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		pnlTelefonos.setBounds(10, 242, 598, 122);
		pnlPrincipal.add(pnlTelefonos);
		
		JScrollPane scrTelefonos = new JScrollPane();
		scrTelefonos.setBounds(63, 28, 375, 74);
		pnlTelefonos.add(scrTelefonos);
		
		tblTelefonos = new JTable();
		tblTelefonos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Nro. teléfono", "Descripción"
	            }
	        ));
		
		tblTelefonos.getTableHeader().setReorderingAllowed(false);
		
		scrTelefonos.setViewportView(tblTelefonos);
		
		btnAgregarTelefono = new JButton("+");
		btnAgregarTelefono.setToolTipText("Agrega un teléfono");
		btnAgregarTelefono.setBounds(482, 28, 52, 26);
		pnlTelefonos.add(btnAgregarTelefono);
		
		btnEliminarTelefono = new JButton("-");
		btnEliminarTelefono.setToolTipText("Elimina el teléfono seleccionado");
		
		btnEliminarTelefono.setBounds(482, 76, 52, 26);
		pnlTelefonos.add(btnEliminarTelefono);
		
		JDateChooser dtpFechaNacimiento = new JDateChooser(); 
                dtpFechaNacimiento.setBounds(463, 80, 145, 26);
                pnlPrincipal.add(dtpFechaNacimiento);
		
		JScrollPane scrConsulta = new JScrollPane();
		scrConsulta.setBounds(12, 64, 574, 127);
		pnlConsultar.add(scrConsulta);
		
		tblConsulta = new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	    
		tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Identificación", "Nombres", "Apellidos", "Fecha nacimiento", "Tipo contacto"
	            }
	        ));
		
		tblConsulta.getTableHeader().setReorderingAllowed(false);
		
		scrConsulta.setViewportView(tblConsulta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(326, 203, 100, 26);
		pnlConsultar.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(172, 203, 100, 26);
		pnlConsultar.add(btnModificar);
		
		cmbTipoContacto = new JComboBox<String>();
		cmbTipoContacto.setModel(new DefaultComboBoxModel<String>(new String[] {"- Seleccione -", "Empleado", "Estudiante", "Profesor"}));
		cmbTipoContacto.setBounds(141, 80, 145, 26);
		pnlPrincipal.add(cmbTipoContacto);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(114, 378, 100, 26);
		pnlPrincipal.add(btnGuardar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.setBounds(260, 378, 100, 26);
		pnlPrincipal.add(btnCancelar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(406, 378, 100, 26);
		pnlPrincipal.add(btnSalir);		
	}

    
    
    
}
