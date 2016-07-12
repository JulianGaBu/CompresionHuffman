/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Caracteres.*;
import Listas.ColaListaSimple;
import java.util.ArrayList;

/**
 *
 * @author rodrigopeniche
 */
public class Texto {

//    String text = "Ser, o no ser, ésa es la cuestión. ¿Cuál es más digna acción del ánimo, sufrir los tiros penetrantes de la fortuna injusta, u oponer los brazos a este torrente de calamidades, y darlas fin con atrevida resistencia? Morir es dormir. ¿No más? ¿Y por un sueño, diremos, las aflicciones se acabaron y los dolores sin número, patrimonio de nuestra débil naturaleza?... Este es un término que deberíamos solicitar con ansia. Morir es dormir... y tal vez soñar. Sí, y ved aquí el grande obstáculo, porque el considerar que sueños podrán ocurrir en el silencio del sepulcro, cuando hayamos abandonado este despojo mortal, es razón harto poderosa para detenernos. Esta es la consideración que hace nuestra infelicidad tan larga. ¿Quién, si esto no fuese, aguantaría la lentitud de los tribunales, la insolencia de los empleados, las tropelías que recibe pacífico el mérito de los hombres más indignos, las angustias de un mal pagado amor, las injurias y quebrantos de la edad, la violencia de los tiranos, el desprecio de los soberbios? Cuando el que esto sufre, pudiera procurar su quietud con sólo un puñal. ¿Quién podría tolerar tanta opresión, sudando, gimiendo bajo el peso de una vida molesta si no fuese que el temor de que existe alguna cosa más allá de la Muerte (aquel país desconocido de cuyos límites ningún caminante torna) nos embaraza en dudas y nos hace sufrir los males que nos cercan; antes que ir a buscar otros de que no tenemos seguro conocimiento? Esta previsión nos hace a todos cobardes, así la natural tintura del valor se debilita con los barnices pálidos de la prudencia, las empresas de mayor importancia por esta sola consideración mudan camino, no se ejecutan y se reducen a designios vanos. Pero... ¡la hermosa Ofelia! Graciosa niña, espero que mis defectos no serán olvidados en tus oraciones.";
    ArrayList<Caracter> caracteres = new ArrayList<>();
    String huffman = "";
    String text = "President Barack Obama has urged the US to \"reject despair\" as he paid tribute to five police officers killed during a deadly sniper attack in Dallas.\n" +
"He told a memorial service in the city the US must \"try to find some meaning amidst our sorrow\" and could unite.\n" +
"His trip came amid mounting racial tensions across the country.\n" +
"Micah Johnson killed the Dallas officers at a protest held over the recent police shootings of African Americans in Minnesota and Louisiana.\n" +
"Before he was killed by police, he said he was angry about the shootings.\n" +
"Meanwhile, protests over excessive police force against black Americans have been held in cities across the US.\n" +
"But speaking at Morton H Meyerson Symphony Center in Dallas on Tuesday, Mr Obama urged the country not to despair.\n" +
"Americans are struggling with what has happened in the past week, he said, and events appeared to have revealed \"the deepest fault line of our democracy\".\n" +
"\"I'm here to say we must reject such despair. I'm here to insist that we are not as divided as we seem.\"\n" +
"He honoured the bravery of police officers and said fewer people were being mourned at the service because of the courage of the officers killed.\n" +
"Dallas police chief scarred by tragedy\n" +
"Who were the victims?\n" +
"US police: 'We are not punching bags'\n" +
"The service featured five portraits of the officers and five empty chairs.\n" +
"Ex-President George W Bush, a Texan, praised the police: \"Their courage is our protection and shield.\"\n" +
"And Dallas Mayor Mike Rawlings, who spoke first, said: \"The soul of our city was pierced.\"\n" +
"First Lady Michelle Obama, Vice President Joe Biden and his wife, Jill, will also meet privately with the families of the victims on Wednesday.";
    Caracter caracter;
    ListaCar listaCar = new ListaCar();
    ColaListaSimple colaCaracteres = new ColaListaSimple();
    ArrayList<Caracter> compresion = new ArrayList<>();
    ArrayList<String> textocompreso = new ArrayList<>();

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
    }

    public void crearLista() {
        for (int i = 0; i < caracteres.size(); i++) {
            listaCar.insertaOrdenado(new NodoCar((Caracter) caracteres.get(i)));
        }
        arbolize();
    }

    public void arbolize() {
        listaCar.superbolize();
    }

    public void comprimir(ArbolCaracter arbol) {
        ColaListaSimple cola = arbol.getColaCaracteres();
        while (!cola.isEmpty()) {
            compresion.add((Caracter) cola.dequeue());
        }

        for (int i = 0; i < compresion.size(); i++) {
            System.out.println(compresion.get(i).getCaracter() + " " + compresion.get(i).getCodigo());
        }

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

    public void convertirString() {

        for (int i = 0; i < textocompreso.size(); i++) {
            huffman += textocompreso.get(i);
        }
        System.out.println(huffman);

    }

    public void convertiraBytes() {
        String binario;
        Convert conv = new Convert(huffman);

        conv.guarda_bin();
        binario = conv.lee_dec();
        descomprimir(binario);
    }

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
        t.contarCaracteres();
        t.eliminarRepeticiones();
        t.crearLista();
        System.out.println("lol");

    }
}
