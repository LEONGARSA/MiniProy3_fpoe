/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.univalle.contactos;

import co.edu.univalle.contactos.controller.Controller;
import co.edu.univalle.contactos.model.Model;
import co.edu.univalle.contactos.view.View;

/**
 *
 * @author LEONARDO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    		View view = new View();
		Model model = new Model();
		
		Controller controller = new Controller(view, model);
		controller.initialize();
    }
    
}
