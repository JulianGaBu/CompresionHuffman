/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Julian
 */
public final class Texto {
    private final String filepath;
    public String text = "";
    private ArrayList<Caracter> caracteres = new ArrayList<>();

    public Texto(String filepath) {
        this.filepath = filepath;
        this.text = leerArchivo(this.filepath);
        this.caracteres = contarCaracteres();
    }
    
    public String getText(){
        return text;
    }
    public ArrayList<Caracter> getCaracteres(){
        return caracteres;
    }
     /**
     * Extrae el texto de un archivo txt
     * @param filepath - la ruta del archivo txt
     * @return El texto extraido del txt
     */
    private String leerArchivo(String filepath) {
        Scanner fileIn;
        String linea;
        try {
            fileIn = new Scanner(new FileReader(filepath));
            while (fileIn.hasNextLine()) {
                linea = fileIn.nextLine();
                text += linea;
            }
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }
        return text;
    }
    
    /**
     * Cuenta los caracteres del texto extraido.
     * 
     * @return Arreglo con cada caracter y su frecuencia
     */
    public ArrayList<Caracter> contarCaracteres() {
        Caracter caracter;
        //cuenta los caracteres (a todos les da valor de 1, repeticiones de 1s posibles)
        for (int i = 0; i < text.length(); i++) {
            caracter = new Caracter();
            caracter.setCaracter(text.charAt(i));
            caracter.setFrecuencias(1);
            caracteres.add(caracter);
        }
        //elimina repeticiones
        for (int i = 0; i < caracteres.size(); i++) {
            for (int j = i; j < caracteres.size(); j++) {
                if (!(i == j)) {
                    if (caracteres.get(i).getCaracter() == caracteres.get(j).getCaracter()) {
                        caracteres.remove(j);
                        caracteres.get(i).setFrecuencias(caracteres.get(i).getFrecuencias() + 1);
                        i = 0;
                    }
                }
            }
        }
        return caracteres;
    }
    
}
