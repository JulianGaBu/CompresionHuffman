/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArbolCaracter;
import Modelo.Caracter;
import Modelo.Texto;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public final class Compresion {
    
    protected Texto texto;
    protected Conversion convertidor;
    protected ArrayList<Caracter> codeList;
    private ArbolCaracter arbol;
    public Byte[] arrBytes;

    /**
     * Genera una nueva compresion desde el archivo especificado
     * @param filepath ruta del archivo
     */
    public Compresion(String filepath) {
        //se extrae el texto del archivo
        this.texto = new Texto(filepath);
        //se genera el arbol y se extraen sus codigos
        this.arbol = new ArbolCaracter(texto.getCaracteres());
        arbol.codificar();
        this.codeList = arbol.getCodigos();
    }
    
    /**
     * Pasa el string de texto a un arreglo de codigos
     * <p>
     * Llama a convertirString() y convertiraBytes()
     */
    public void comprimir() {
        //va a guardar el texto codificado en un arraylist
        ArrayList<String> textoCompreso = new ArrayList<>();
        for (int i = 0; i < texto.getText().length(); i++) {
            for (int j = 0; j < codeList.size(); j++) {
                if (texto.getText().charAt(i) == codeList.get(j).getCaracter()) {
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
        convertidor = new Conversion(huffman);
        convertidor.guarda_bin();
        
        //obtiene el arreglo de bytes y el string que extrae
        arrBytes = convertidor.getBytes();
    }
    
    /**
     * @return texto extraido del archivo
     */
    public String getText(){
        return texto.text;
    }

}
