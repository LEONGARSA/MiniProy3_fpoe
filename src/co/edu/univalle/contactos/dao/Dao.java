/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.univalle.contactos.dao;

import java.util.List;
import co.edu.univalle.contactos.model.Model;

/**
 *
 * @author LEONARDO
 */
public interface Dao {
    
    public List<Model> getAllEmpleados();
    public Model getEmpleado(int empleadoId);
    public boolean addEmpleado(Model persona);
    public boolean updateEmpleado(Model persona);
    public boolean deleteEmpleado(Model persona);

    
    
}
