/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author LEONARDO
 */
public interface IPersonaDao {
    
    public List<Empleado> getAllEmpleados();
    public Empleado getEmpleado(int empleadoId);
    public boolean addEmpleado(Empleado empleado);
    public boolean updateEmpleado(Empleado empleado);
    public boolean deleteEmpleado(Empleado empleado);

    
    
}
