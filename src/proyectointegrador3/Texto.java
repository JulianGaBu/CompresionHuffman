/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador3;

import java.util.ArrayList;

/**
 *
 * @author rodrigopeniche
 */
public class Texto {

    String text = "Ser, o no ser, ésa es la cuestión. ¿Cuál es más digna acción del ánimo, sufrir los tiros penetrantes de la fortuna injusta, u oponer los brazos a este torrente de calamidades, y darlas fin con atrevida resistencia? Morir es dormir. ¿No más? ¿Y por un sueño, diremos, las aflicciones se acabaron y los dolores sin número, patrimonio de nuestra débil naturaleza?... Este es un término que deberíamos solicitar con ansia. Morir es dormir... y tal vez soñar. Sí, y ved aquí el grande obstáculo, porque el considerar que sueños podrán ocurrir en el silencio del sepulcro, cuando hayamos abandonado este despojo mortal, es razón harto poderosa para detenernos. Esta es la consideración que hace nuestra infelicidad tan larga. ¿Quién, si esto no fuese, aguantaría la lentitud de los tribunales, la insolencia de los empleados, las tropelías que recibe pacífico el mérito de los hombres más indignos, las angustias de un mal pagado amor, las injurias y quebrantos de la edad, la violencia de los tiranos, el desprecio de los soberbios? Cuando el que esto sufre, pudiera procurar su quietud con sólo un puñal. ¿Quién podría tolerar tanta opresión, sudando, gimiendo bajo el peso de una vida molesta si no fuese que el temor de que existe alguna cosa más allá de la Muerte (aquel país desconocido de cuyos límites ningún caminante torna) nos embaraza en dudas y nos hace sufrir los males que nos cercan; antes que ir a buscar otros de que no tenemos seguro conocimiento? Esta previsión nos hace a todos cobardes, así la natural tintura del valor se debilita con los barnices pálidos de la prudencia, las empresas de mayor importancia por esta sola consideración mudan camino, no se ejecutan y se reducen a designios vanos. Pero... ¡la hermosa Ofelia! Graciosa niña, espero que mis defectos no serán olvidados en tus oraciones.";
    ArrayList<Caracter> caracteres = new ArrayList<>();
    Caracter caracter;
    ListaSimple lista = new ListaSimple();
    ListaCar listaCar = new ListaCar();
    ColaListaSimple colaCaracteres = new ColaListaSimple();
    ColaListaSimple colaNodoCaracteres = new ColaListaSimple();
    ArbolBB arbol;

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
                }
            }
        }
    }

    public void impresionPrueba() {
        for (int i = 0; i < caracteres.size(); i++) {
            System.out.println("Caracter:  " + caracteres.get(i).getCaracter() + "  Ocurrencias:  " + caracteres.get(i).getFrecuencias());
        }
    }

    public void crearLista() {
        for (int i = 0; i < caracteres.size(); i++) {
            lista.insertaOrdenado(caracteres.get(i));
            listaCar.insertaOrdenado(new NodoCar((Caracter) caracteres.get(i)));
        }

        while (!lista.vacio()) {
            colaCaracteres.enqueue((Caracter) ((Nodo) lista.eliminaInicio()).getDato());
        }

        System.out.println("help");
        lista.imprimir();
    }

    public void arbolize() {
        listaCar.superbolize();
    }

    public void crearNodos() {
        int comparador = 0;
        Caracter aux, aux2;
        while (!colaCaracteres.isEmpty()) {
            aux = (Caracter) colaCaracteres.dequeue();
            aux2 = (Caracter) colaCaracteres.dequeue();
            comparador = aux.getFrecuencias() + aux2.getFrecuencias();
            colaNodoCaracteres.enqueue(new NodoBin(comparador, new NodoBin(aux), new NodoBin(aux2)));
            if (colaCaracteres.size() < 2) {
                colaNodoCaracteres.enqueue(new NodoBin((Caracter)colaCaracteres.dequeue()));
                System.out.println("help");
                break;
            }
        }
        treeGen();
    }

    public void treeGen() {
        if (colaNodoCaracteres.size() > 1) {
            treeGenerator(colaNodoCaracteres);
        }
    }

    public void treeGenerator(ColaListaSimple cola) {
        ColaListaSimple colaNodoBin = new ColaListaSimple();
        NodoBin aux, aux2;
        while (!cola.isEmpty()) {
            aux = (NodoBin) cola.dequeue();
            aux2 = (NodoBin) cola.dequeue();
            colaNodoBin.enqueue(new NodoBin(((int) aux.getDato() + (int) aux2.getDato()), aux, aux2));
            if (cola.size() < 2) {
                break;
            }
        }
        if (colaNodoBin.size() > 1) {
            treeGenerator(colaNodoBin);
        } else {
            arbol = new ArbolBB(colaNodoBin.dequeue());
        }
    }

    public void bfs() {
        listaCar.bfs(listaCar.inicio);
    }

    public static void main(String[] args) {

        Texto t = new Texto();
        t.contarCaracteres();
        t.eliminarRepeticiones();
        t.impresionPrueba();
        t.crearLista();
        t.arbolize();
        System.out.println("lol");
        t.listaCar.preorden();

    }
}
