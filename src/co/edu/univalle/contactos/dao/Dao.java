/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Persona;

/**
 *
 * @author LEONARDO
 */
public interface IPersonaDao {
    
    public List<Persona> getAllEmpleados();
    public Persona getEmpleado(int empleadoId);
    public boolean addEmpleado(Persona persona);
    public boolean updateEmpleado(Persona persona);
    public boolean deleteEmpleado(Persona persona);

    
    
}
