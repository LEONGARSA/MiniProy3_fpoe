/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioenclaseficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author LEONARDO
 */
public class Ejercicioenclaseficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        
        //FileReader fr = new FileReader("C:\\Users\\LEONARDO\\Desktop\\Leo & Laura\\MiniProy3_fpoe\\ejercicioenclaseficheros\\src\\ejercicioenclaseficheros\\fichero1.txt");
        File archivo = new File ("C:\\Users\\LEONARDO\\Desktop\\Leo & Laura\\MiniProy3_fpoe\\ejercicioenclaseficheros\\src\\ejercicioenclaseficheros\\fichero1.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        int contador = 0;
        ArrayList<String> palasbras = new ArrayList<String>();
        
        while((linea = br.readLine())!=null)
        {
            contador++;
//            System.out.println(linea);
            palasbras.add(linea);
            
        }
        System.out.println("contador " + contador);
        
        StringTokenizer st = null;
        int acumulador = 0;
        for(int i =0; i< palasbras.size();i++)
        {
            System.out.println(palasbras.get(i));
            st = new StringTokenizer(palasbras.get(i));
            acumulador+=st.countTokens();
        }
        
        
        System.out.println(acumulador);
        Scanner Sc = new Scanner (System.in);
        String palabra = Sc.nextLine();
        acumulador = 0;
        for(int i =0; i< palasbras.size();i++)
        {
            if(palasbras.get(i).contains(palabra)){
            
            acumulador++;
            }
        }
        
        System.out.println(acumulador);
    }  
    
}
