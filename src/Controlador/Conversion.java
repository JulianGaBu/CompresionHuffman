package Controlador;

public class Conversion {

    String sText;
    Byte[] bText; //almacena el arreglo de bytes

    public Conversion(String huffman) {
        sText = huffman;
        // sText= "001010101011011010100110";
        //si el bit mas a la izq esta en 1 se toma como negativo
        int cant = (sText.length() % 8 == 0) ? (sText.length() / 8) : (sText.length() / 8 + 1);
        bText = new Byte[cant]; //almacena el arreglo de bytes
    }
 
    //recibe una cadena con una secuencia binaria y lo convierte a arreglo de bytes
    //con los valores convertidos a enteros tomando de 8 en 8 bits
    public void guarda_bin() {
        int nIter = 0, cuenta = 0;
        String subcadena;
        do {
            if (nIter <= sText.length() - 8) {
                subcadena = sText.substring(nIter, nIter + 8);
            } else {
                subcadena = sText.substring(nIter, sText.length());
                int restan = 8 - subcadena.length();
                for (int k = 0; k < restan; k++) {
                }
                subcadena += "0"; //completar ceros faltantes
            }
            //Convert ascii to Int
            Byte decimal = (byte) Integer.parseInt(subcadena, 2);
            //System.out.println(decimal); //se imprime con el signo, no importa
            bText[cuenta++] = decimal;
            //guardar el valor de la variable decimal en el archivo
            nIter += 8;
        } while (nIter < sText.length());
    }

    //lee el arreglo decimal y lo convierte a string (como secuencia de bits)
    public static String lee_dec(Byte[] bText) {
        String resultado = "";
        String aCadenaBinario = "";
        String subcadena = "";
        for (Byte bText1 : bText) {
            aCadenaBinario = Integer.toBinaryString((int) bText1);
            if (aCadenaBinario.length() == 32) {
                //copiar ultimo octeto del int (4 bytes), por el signo negativo al inicio
                subcadena = aCadenaBinario.substring(aCadenaBinario.length() - 8, aCadenaBinario.length());
                resultado += subcadena;
            } else {
                subcadena = "";
                for (int k = 0; k < 8 - aCadenaBinario.length(); k++) {
                    subcadena += "0"; //agregar ceros al inicio
                }
                resultado += (subcadena + aCadenaBinario);
            }
        }
        System.out.println("Codificado: " + resultado);

        return resultado;

    }

    public Byte[] getBytes() {
        return bText;
    }
}
