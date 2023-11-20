/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LEONARDO
 */
public class Persona {
    private String id;
    private String nombres;
    private String apellidos;
    private List <String> direccion;
    private HashMap <String,String> telefono;
    private Date fechaNacimiento;    
    private String RolUniversitario;

    public Persona(String id, String nombres, String apellidos, List<String> direccion, HashMap<String, String> telefono, Date fechaNacimiento, String RolUniversitario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.RolUniversitario = RolUniversitario;
    }

    public String getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public List<String> getDireccion() {
        return direccion;
    }

    public HashMap<String, String> getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRolUniversitario() {
        return RolUniversitario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(List<String> direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(HashMap<String, String> telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setRolUniversitario(String RolUniversitario) {
        this.RolUniversitario = RolUniversitario;
    }


    
    
}