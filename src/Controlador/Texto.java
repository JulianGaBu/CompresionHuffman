/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Caracteres.*;
import Listas.ColaListaSimple;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodrigopeniche
 */
public class Texto {
    
    //lista de caracteres
    ArrayList<Caracter> caracteres = new ArrayList<>();
    String huffman = "";
    String text = "";
//    String text = "President Barack Obama has urged the US to \"reject despair\" as he paid tribute to five police officers killed during a deadly sniper attack in Dallas.\n" +
//"He told a memorial service in the city the US must \"try to find some meaning amidst our sorrow\" and could unite.\n" +
//"His trip came amid mounting racial tensions across the country.\n" +
//"Micah Johnson killed the Dallas officers at a protest held over the recent police shootings of African Americans in Minnesota and Louisiana.\n" +
//"Before he was killed by police, he said he was angry about the shootings.\n" +
//"Meanwhile, protests over excessive police force against black Americans have been held in cities across the US.\n" +
//"But speaking at Morton H Meyerson Symphony Center in Dallas on Tuesday, Mr Obama urged the country not to despair.\n" +
//"Americans are struggling with what has happened in the past week, he said, and events appeared to have revealed \"the deepest fault line of our democracy\".\n" +
//"\"I'm here to say we must reject such despair. I'm here to insist that we are not as divided as we seem.\"\n" +
//"He honoured the bravery of police officers and said fewer people were being mourned at the service because of the courage of the officers killed.\n" +
//"Dallas police chief scarred by tragedy\n" +
//"Who were the victims?\n" +
//"US police: 'We are not punching bags'\n" +
//"The service featured five portraits of the officers and five empty chairs.\n" +
//"Ex-President George W Bush, a Texan, praised the police: \"Their courage is our protection and shield.\"\n" +
//"And Dallas Mayor Mike Rawlings, who spoke first, said: \"The soul of our city was pierced.\"\n" +
//"First Lady Michelle Obama, Vice President Joe Biden and his wife, Jill, will also meet privately with the families of the victims on Wednesday.";
    Caracter caracter;
    ArbolCaracter arbol;
    ListaCar listaCar = new ListaCar();
    ColaListaSimple colaCaracteres = new ColaListaSimple();
    ArrayList<Caracter> compresion = new ArrayList<>();
    ArrayList<String> textocompreso = new ArrayList<>();

    public Texto() {
        
    }
    public void leerArchivo() {
        Scanner fileIn;
        String linea;
        
        try {
            fileIn = new Scanner(new FileReader("C:\\Users\\Julian\\Documents\\NetBeansProjects\\Estructuras Final Lap\\ProyectoFinal\\src\\obama.txt"));
            while (fileIn.hasNextLine()) {
                linea = fileIn.nextLine();
                text += linea;
            }
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }
        System.out.println(text);
    }

//Cuenta de frecuencias de cada caracter
    public void contarCaracteres() {
        for (int i = 0; i < text.length(); i++) {
            caracter = new Caracter();
            caracter.setCaracter(text.charAt(i));
            caracter.setFrecuencias(1);
            caracteres.add(caracter);
        }
    }
    
    public void eliminarRepeticiones() {
        for (int i = 0; i < caracteres.size(); i++) {
            for (int j = i; j < caracteres.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (caracteres.get(i).getCaracter() == caracteres.get(j).getCaracter()) {
                    caracteres.remove(j);
                    caracteres.get(i).setFrecuencias(caracteres.get(i).getFrecuencias() + 1);
                    i = 0;
                }
            }
        }
        System.out.println("textER" + text);
    }

//crea la lista de caracteres y lanza el generamiento de arboles
    public void crearLista() {
        for (int i = 0; i < caracteres.size(); i++) {
            listaCar.insertaOrdenado(new NodoCar((Caracter) caracteres.get(i)));
        }
        listaCar.superbolize();
        System.out.println("textSB" + text);
    }

//Compresion, conversion y decodificacion
    //pasa el texto a codigo en un arraylist de strings
    public void comprimir(ArbolCaracter arbol) {
        ColaListaSimple cola = arbol.getColaCaracteres();
        while (!cola.isEmpty()) {
            compresion.add((Caracter) cola.dequeue());
        }
        
        for (int i = 0; i < compresion.size(); i++) {
            System.out.println(compresion.get(i).getCaracter() + " " + compresion.get(i).getCodigo());
        }
        System.out.println("textlol");
        System.out.println(text);
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < compresion.size(); j++) {
                if (text.charAt(i) == compresion.get(j).getCaracter()) {
                    textocompreso.add(compresion.get(j).getCodigo());
                }
            }
        }
        convertirString();
        convertiraBytes();
    }

    //convierte el arreglo de codigos en un solo string
    public void convertirString() {
        
        for (int i = 0; i < textocompreso.size(); i++) {
            huffman += textocompreso.get(i);
        }
        System.out.println("huffman:");
        System.out.println(huffman);
        
    }

    //convierte el string en bytes
    public void convertiraBytes() {
        String binario;
        Convert conv = new Convert(huffman);
        
        conv.guarda_bin();
        binario = conv.lee_dec();
        descomprimir(binario);
    }

    //descomprime los bytes en un string
    public void descomprimir(String binario) {
        String substring = "";
        String decodificacion = "";
        for (int i = 0; i < binario.length(); i++) {
            substring += binario.charAt(i);
            for (int j = 0; j < compresion.size(); j++) {
                if (substring.equals(compresion.get(j).getCodigo())) {
                    decodificacion += compresion.get(j).getCaracter();
                    substring = "";
                }
            }
        }
        
        System.out.println(decodificacion);
    }
    
    public static void main(String[] args) {
        
        Texto t = new Texto();
        //t.leerArchivo();
        t.contarCaracteres();
        t.eliminarRepeticiones();
        t.crearLista();
//        t.comprimir(t.);
        System.out.println("lol");
        
    }
}
