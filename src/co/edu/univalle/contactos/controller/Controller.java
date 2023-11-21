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
}
