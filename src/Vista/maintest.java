/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Hash;

/**
 *
 * @author Julian
 */
public class maintest {
    public static void main(String[] args) {
        Hash hashtest = new Hash("C:\\Users\\Julian\\Documents\\NetBeansProjects\\Estructuras Final Lap\\ProyectoFinal\\obama.txt");
        hashtest = new Hash("C:\\Users\\Julian\\Documents\\NetBeansProjects\\Estructuras Final Lap\\obama2copia.txt");
        System.out.println(Hash.getFilePath("obama.txt"));
    }
    
}
