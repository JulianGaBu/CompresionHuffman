/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Julian
 */
public class BinaryFileIO {

    private static ArrayList<Caracter> codeList;

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
        appendTable(codigos, filepath);
        Hash hash = new Hash(filepath);
    }

    public static void appendTable(ArrayList<Caracter> codigos, String filepath) throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter(filepath, true));
        fileOut.println(" ");
        fileOut.println("cdg");
        for (int i = 0; i < codigos.size(); i++) {
            fileOut.println(" " + codigos.get(i).getCaracter() + " " + codigos.get(i).getCodigo());
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
    
    public void lol() throws UnsupportedEncodingException, FileNotFoundException, IOException{
        File file = new File("/path/to/file.txt");
        File temp = File.createTempFile("file", ".txt", file.getParentFile());
        String charset = "UTF-8";
        String delete = "foo";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
        for (String line; (line = reader.readLine()) != null;) {
            line = line.replace(delete, "");
            writer.println(line);
        }
        reader.close();
        writer.close();
        file.delete();
        temp.renameTo(file);
    }

    public static Byte[] leerArchivo(String filepath) throws IOException {
        codeList = new ArrayList<>();
        File file = new File(filepath);
        Path path = Paths.get(file.getAbsolutePath());
        byte[] data = Files.readAllBytes(path);
        Byte[] datos = new Byte[data.length];
        Arrays.setAll(datos, n -> data[n]);
        String linea;
        Scanner fileIn;
        StringTokenizer st;
        Caracter car;
        boolean band = false;

        try {
            fileIn = new Scanner(new FileReader(filepath));
            while (fileIn.hasNextLine()) {
                car = new Caracter();
                if (band == false) {
                    linea = fileIn.nextLine();
                    while (!linea.equals("cdg")) {
                        linea = fileIn.nextLine();
                    }
                    band = true;
                }
                linea = fileIn.nextLine();
                st = new StringTokenizer(linea);
                if (st.countTokens() < 2) {
                    car.setCaracter(' ');
                    car.setCodigo(st.nextToken());
                } else {
                    car.setCaracter(st.nextToken().charAt(0));
                    car.setCodigo(st.nextToken());
                }
                codeList.add(car);
                System.out.println(car.getCaracter() + " " + car.getCodigo());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }

        return datos;
    }

    public static ArrayList<Caracter> getCodeList() {
        return codeList;
    }

}
