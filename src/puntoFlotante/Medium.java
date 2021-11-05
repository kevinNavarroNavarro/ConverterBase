package puntoFlotante;

import calculatorConverter.CalculartorConverter;

import java.util.Arrays;

public class Medium {

    CalculartorConverter calculatorConverter = new CalculartorConverter();

    private Byte[] valor = new Byte[3];

    public Medium() {
        this.valor = new Byte[] { 0, 0, 0 };
    }

    public Medium(String valorDecimal) {

        System.out.println("Entrada: '" + valorDecimal + "'");

        String binario = agregarCeros(valorDecimal);

        // Ingresa los numeros a valor Byte[3] segun su signo (+) o (-)
        if (binario.charAt(0) == '1') {
            System.out.println("binario en pos1: " + binario.substring(0, 8) + " = -"
                    + Integer.parseInt(binario.substring(1, 8), 2));
            this.valor[0] = Byte.parseByte("-" + Integer.parseInt(binario.substring(1, 8), 2));
        } else {
            System.out.println("binario en pos1: " + binario.substring(1, 8) + " = "
                    + Integer.parseInt(binario.substring(1, 8), 2));
            this.valor[0] = Byte.parseByte("" + Integer.parseInt(binario.substring(1, 8), 2));
        }

        if (binario.charAt(8) == '1') {
            System.out.println("binario en pos2: " + binario.substring(8, 16) + " = -"
                    + Integer.parseInt(binario.substring(9, 16), 2));
            this.valor[1] = Byte.parseByte("-" + Integer.parseInt(binario.substring(9, 16), 2));
        } else {
            System.out.println("binario en pos2: " + binario.substring(8, 16) + " = "
                    + Integer.parseInt(binario.substring(9, 16), 2));
            this.valor[1] = Byte.parseByte("" + Integer.parseInt(binario.substring(9, 16), 2));
        }

        if (binario.charAt(16) == '1') {
            System.out.println(
                    "binario en pos3: " + binario.substring(16) + " = -" + Integer.parseInt(binario.substring(17), 2));
            this.valor[2] = Byte.parseByte("-" + Integer.parseInt(binario.substring(17), 2));

        } else {
            System.out.println(
                    "binario en pos3: " + binario.substring(16) + " = " + Integer.parseInt(binario.substring(17), 2));
            this.valor[2] = Byte.parseByte("" + Integer.parseInt(binario.substring(17), 2));
        }

        /*
         * El problema con este es que al pasarlo a byte le vuelve a sacar complemento a 2
         */
        /*
        this.valor[0] = (byte) Integer.parseInt(binario.substring(0, 8), 2);
        this.valor[1] = (byte) Integer.parseInt(binario.substring(8, 16), 2);
        this.valor[2] = (byte) Integer.parseInt(binario.substring(16), 2);
        */
        System.out.println("Array Byte[3]: " + Arrays.toString(this.valor));

    }

    public Medium(String valorHexadecimal, String tipo) {

    }

    private String agregarCeros(String decimal) {
        String binario = "";
        boolean esNegativo = false;

        binario = Integer.toBinaryString(Integer.parseInt(decimal));

        if ((decimal.charAt(0)) == '-') {
            System.out.println("Es negativo por lo tanto se complementa");
            esNegativo = true;
        }

        String ceros = "";

        if (!esNegativo) {
            for (int i = binario.length(); i < 24; i++) {
                ceros += "0";
            }

            binario = ceros + binario;
        } else {
            // recorto a 24 bits
            binario = binario.substring(8);
        }

        System.out.println("binario: " + binario + " : " + binario.length() + " bits");

        return binario;
    }

    public Byte[] getValor() {
        return valor;
    }

    public void setValor(Byte[] valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Medium{" + "valor=" + Arrays.toString(valor) + '}';
    }
}
