/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Compresion;
import Controlador.Descompresion;

/**
 *
 * @author Julian
 */
public class Main {
    public static void main(String[] args) {
        Compresion comp = new Compresion("obama.txt");
        System.out.print("Texto Original: "+comp.getText());
        comp.comprimir();
        System.out.println("\ndescomprimiendo...");
        Descompresion descomp = new Descompresion(comp);
        descomp.descomprimir();
    }
    
}
