/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class Descompresion {
    String binario;
    ArrayList<Caracter> codeList = new ArrayList<>();

    /**
     * Constructor de descompresion
     * @param filepath ruta del archivo
     * <p>
     * extrae el arreglo de bytes de comp
     * genera un string desde el arreglo de bytes con Conversion
     */
    public Descompresion(String filepath) throws IOException {
        this.binario = Conversion.lee_dec(BinaryFileIO.leerArchivo(filepath));
        this.codeList = BinaryFileIO.getCodeList();
    }
    
    /**
     * Descomprime los bytes en un string
     * <p>
     * Utiliza el string obtenido desde el Conversion heredado del objeto compresion
     */
    public void descomprimir() {
        String substring = "";
        String decodificacion = "";
        for (int i = 0; i < binario.length(); i++) {
            substring += binario.charAt(i);
            for (int j = 0; j < codeList.size(); j++) {
                if (substring.equals(codeList.get(j).getCodigo())) {
                    decodificacion += codeList.get(j).getCaracter();
                    substring = "";
                }
            }
        }
        System.out.println(decodificacion);
    }
}
