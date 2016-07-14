/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian
 */
public final class Hash {
    private static final String[] HASHTABLE = new String[100];
    private int indice;
    public static ArrayList<String> fileNames = new ArrayList<>();
    
    public Hash(String filepath) {
        String filename = extractFileName(filepath);
        this.indice = Math.abs(filename.hashCode()%100);
        System.out.println(indice);
        HASHTABLE[indice] = filepath;
        Hash.fileNames.add(filename);        
    }
    
    public String extractFileName(String filepath){
        String fName = "";
        for (int i = filepath.lastIndexOf("\\") + 1; i < filepath.length(); i++) {
            fName += filepath.charAt(i);
        }
        return fName;
    }
    
    public static String getFilePath(String fileName){
        int indice = Math.abs(fileName.hashCode()%100);
        if(HASHTABLE[indice]==null){
            System.out.println("Indice no encontrado");
            return null;
        }else
            return HASHTABLE[indice];
    }
    
    public static  ArrayList<String> getFileNames(){
        return fileNames;
    }
    
            
}
