/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.contactos.vo;

/**
 *
 * @author LAURA
 */
public class Telefono {
    
    private String nroTelefono;
	private String descripcion;
	
	public Telefono(String nroTelefono, String descripcion) {
		this.nroTelefono = nroTelefono;
		this.descripcion = descripcion;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}
        
        public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}        

}
