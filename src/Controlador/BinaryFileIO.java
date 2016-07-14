/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Julian
 */
public class BinaryFileIO {

    public static void guardarArchivo(String filepath, Byte[] arrBytes, ArrayList<Caracter> codigos) throws IOException {
        try {
            byte[] bytearray = new byte[arrBytes.length];
            for (int i = 0; i < arrBytes.length; i++) {
                bytearray[i] = arrBytes[i];
            }
            try (FileOutputStream fileOuputStream = new FileOutputStream(filepath)) {
                fileOuputStream.write(bytearray);
            }
        } catch (Exception e) {
            System.out.println("Error fatal");
        }
        appendTable(codigos,filepath);
    }
    
    public static void appendTable(ArrayList<Caracter> codigos,String filepath) throws IOException{
        PrintWriter fileOut = new PrintWriter(new FileWriter(filepath, true));
        fileOut.println(" ");
        fileOut.println("cdg "+codigos.size()*2);
        for(int i = 0; i<codigos.size();i++){
            fileOut.println(" "+codigos.get(i).getCaracter()+" "+codigos.get(i).getCodigo());
        }
        fileOut.close();
    }

    public static void saveHistory(String filepath) throws FileNotFoundException, IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter("historial.txt", true));

        String filename = "";
        for (int i = filepath.lastIndexOf("\\") + 1; i < filepath.length(); i++) {
            filename += filepath.charAt(i);
            System.out.println(i);
        }

        System.out.println("\n" + filename);
        fileOut.println(filename + " " + filepath);
        fileOut.close();
    }

    public static Byte[] leerArchivo(String filepath) throws IOException {
        File file = new File(filepath);
        Path path = Paths.get(file.getAbsolutePath());
        byte[] data = Files.readAllBytes(path);
        Byte[] datos = new Byte[data.length];
        Arrays.setAll(datos, n -> data[n]);

        return datos;

    }
    
}
