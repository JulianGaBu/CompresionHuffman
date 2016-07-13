/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArbolCaracter;
import Modelo.NodoCar;
import Modelo.ListaCar;
import Modelo.Caracter;
import Modelo.ColaListaSimple;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodrigopeniche
 */
public final class Compresion {

    //lista de caracteres
    String text = "";
    
    //arraylist de codigos con su respectivo caracter
    ArrayList<Caracter> codeList = new ArrayList<>();
    
    Convert convertidor;
    ArbolCaracter arbol;
    Byte[] arrBytes;

    /**
     * Genera una nueva compresion desde el archivo especificado
     * @param filepath ruta del archivo
     */
    public Compresion(String filepath) {
        this.text = leerArchivo(filepath);
        this.arbol = crearArbol();
    }

    /**
     * Extrae el texto de un archivo txt
     * @param filepath - la ruta del archivo txt
     * @return El texto extraido del txt
     */
    public String leerArchivo(String filepath) {
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

//Cuenta de frecuencias de cada caracter

    /**
     * Cuenta los caracteres del texto extraido.
     * 
     * @return Arreglo con cada caracter y su frecuencia
     */
    public ArrayList<Caracter> contarCaracteres() {
        ArrayList<Caracter> caracteres = new ArrayList<>();
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
    
//generacion de arbol
    
    /**
     * Crea la lista de NodoCaracteres y genera un arbol dentro de ella
     * 
     * @return el arbol generado desde la lista
     */
    public ArbolCaracter crearArbol() {
        //cuenta los caracteres y los agrega a un ArrayList caracteres
        ArrayList<Caracter> caracteres = contarCaracteres();
        
        //Se crea una ListaCar con cada uno de los Caracteres nodos...
        ListaCar listaCar = new ListaCar();
        for (int i = 0; i < caracteres.size(); i++) {
            listaCar.insertaOrdenado(new NodoCar((Caracter) caracteres.get(i)));
        }
        //...de la cual se genera el arbol
        listaCar.arbolize();
        return new ArbolCaracter(listaCar.getArbolRaiz());
    }
    
//Compresion y conversion
    
    /**
     * Obtiene los codigos desde el arbol huffman
     * <p>
     * Pasa el string de texto a un arreglo de codigos
     * <p>
     * Llama a convertirString() y convertiraBytes()
     */
    public void comprimir() {
        //extrae los codigos del arbol
        arbol.codificar();
        
        //va a guardar el texto codificado en un arraylist
        ArrayList<String> textoCompreso = new ArrayList<>();
        
        ColaListaSimple cola = arbol.getColaCaracteres();
        while (!cola.isEmpty()) {
            codeList.add((Caracter) cola.dequeue());
        }
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < codeList.size(); j++) {
                if (text.charAt(i) == codeList.get(j).getCaracter()) {
                    textoCompreso.add(codeList.get(j).getCodigo());
                }
            }
        }
        convertirString(textoCompreso);
    }

    /**
     * Convierte el arreglo de codigos en un solo string
     * @param textoCompreso arreglo de codigos. va a ser convertido a bytes con
     * convertiraBytes()
     */
    public void convertirString(ArrayList<String> textoCompreso) {
        String huffman = "";
        for (int i = 0; i < textoCompreso.size(); i++) {
            huffman += textoCompreso.get(i);
        }
        convertiraBytes(huffman);
    }

    /**
     * Convierte de String a arreglo de bytes
     * @param huffman String a convertir
     */
    public void convertiraBytes(String huffman) {
        convertidor = new Convert(huffman);
        convertidor.guarda_bin();
        
        //obtiene el arreglo de bytes y el string que extrae
        arrBytes = convertidor.getBytes();
    }
    
    /**
     * @return texto extraido del archivo
     */
    public String getText(){
        return text;
    }

}
