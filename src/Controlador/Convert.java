package Controlador;

public class Convert {

    String sText;
    Byte[] bText; //almacena el arreglo de bytes

    public Convert(String huffman) {
        sText = huffman;
        // sText= "001010101011011010100110";
        //si el bit mas a la izq esta en 1 se toma como negativo
        int cant = (sText.length() % 8 == 0) ? (sText.length() / 8) : (sText.length() / 8 + 1);
        bText = new Byte[cant]; //almacena el arreglo de bytes

    }
//recibe una cadena con una secuencia binaria y lo convierte a arreglo de bytes
//con los valores convertidos a enteros tomando de 8 en 8 bits

    public void guarda_bin() {
        System.out.println("Longitud del string: " + sText.length());
        System.out.println("Secuencia binaria:");
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
            //System.out.println(subcadena);
//Convert ascii to Int
            Byte decimal = (byte) Integer.parseInt(subcadena, 2);
            //System.out.println(decimal); //se imprime con el signo, no importa
            bText[cuenta++] = decimal;
            //guardar el valor de la variable decimal en el archivo
            nIter += 8;
        } while (nIter < sText.length());
    }
//lee el arreglo decimal y lo convierte a string (como secuencia de bits)

    public String lee_dec() {
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

        if (sText.length() % 8 != 0) {
            String lastoriginal;
            String firstresultado;
            switch (sText.length() % 8) {
                case 1:
                    lastoriginal = sText.substring(sText.length() - 2, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 9);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 2:
                    lastoriginal = sText.substring(sText.length() - 2, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 8);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 3:
                    lastoriginal = sText.substring(sText.length() - 3, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 8);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 4:
                    lastoriginal = sText.substring(sText.length() - 4, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 8);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 5:
                    lastoriginal = sText.substring(sText.length() - 6, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 9);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 6:
                    lastoriginal = sText.substring(sText.length() - 7, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 9);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
                case 7:
                    lastoriginal = sText.substring(sText.length() - 1, sText.length());
                    firstresultado = resultado.substring(0, resultado.length() - 2);
                    resultado = firstresultado.concat(lastoriginal);
                    break;
            }
        }

        System.out.println("Original:   " + sText);
        System.out.println("Codificado: " + resultado);

        return resultado;

    }

}
