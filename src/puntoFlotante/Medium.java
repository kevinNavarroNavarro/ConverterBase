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


        String binario = complemento2(valorDecimal);

        // Ingresa los numeros a valor Byte[3] segun su signo (+) o (-)
        if (binario.charAt(0) == '1') {

            this.valor[0] = Byte.parseByte("-" + Integer.parseInt(binario.substring(1, 8), 2));
        } else {

            this.valor[0] = Byte.parseByte("" + Integer.parseInt(binario.substring(1, 8), 2));
        }

        if (binario.charAt(8) == '1') {

            this.valor[1] = Byte.parseByte("-" + Integer.parseInt(binario.substring(9, 16), 2));
        } else {

            this.valor[1] = Byte.parseByte("" + Integer.parseInt(binario.substring(9, 16), 2));
        }

        if (binario.charAt(16) == '1') {

            this.valor[2] = Byte.parseByte("-" + Integer.parseInt(binario.substring(17), 2));

        } else {

            this.valor[2] = Byte.parseByte("" + Integer.parseInt(binario.substring(17), 2));
        }

    }

    public Medium(String valorHexadecimal, String tipo) {
        String binario = convetirABinario(valorHexadecimal);

        // Ingresa los numeros a valor Byte[3] segun su signo (+) o (-)
        if (binario.charAt(0) == '1') {
            this.valor[0] = Byte.parseByte("-" + Integer.parseInt(binario.substring(1, 8), 2));
        } else {

            this.valor[0] = Byte.parseByte("" + Integer.parseInt(binario.substring(1, 8), 2));
        }

        if (binario.charAt(8) == '1') {
            this.valor[1] = Byte.parseByte("-" + Integer.parseInt(binario.substring(9, 16), 2));
        } else {

            this.valor[1] = Byte.parseByte("" + Integer.parseInt(binario.substring(9, 16), 2));
        }

        if (binario.charAt(16) == '1') {

            this.valor[2] = Byte.parseByte("-" + Integer.parseInt(binario.substring(17), 2));

        } else {
            this.valor[2] = Byte.parseByte("" + Integer.parseInt(binario.substring(17), 2));
        }
    }

    private String convetirABinario(String valorHexadecimal){
        String binario = "";
        String ceros = "";
        binario = Integer.toBinaryString(Integer.parseInt(valorHexadecimal, 16));

        //Al convertir de hexadecimal a binario se pierden los 0 delanteros si el numero es menor a 8
        //En este condicion se pregunta si sucedio lo anterior y se los agrega de vuelta
        if (valorHexadecimal.length()*4 != binario.length()){
            String cerosDelanteros = "";
            for (int i = binario.length(); i < valorHexadecimal.length()*4; i++) {
                cerosDelanteros += "0";
            }
            binario = cerosDelanteros + binario;
        }

        for (int i = binario.length(); i < 24; i++) {
            ceros += "0";
        }
        binario = binario + ceros;

        return binario;
    }

    private String complemento2(String decimal) {
        String binario = "";
        boolean esNegativo = false;

        binario = Integer.toBinaryString(Integer.parseInt(decimal));

        if ((decimal.charAt(0)) == '-') {
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
        String decimal = resultadoByte(valor);
        return "Medium{" + "valor=" + Arrays.toString(valor) + '}'+ "\nValor Decimal: " +decimal;
    }

    private static String resultadoByte(Byte[] byteArray){
        Entero e = new Entero();
        String resultado = "";

        for(int i=0;i<3;i++){
            resultado+= e.obtenerBinario(byteArray[i]+"");
        }

        if(resultado.charAt(0)=='1'){
            resultado = Integer.parseInt(resultado, 2)+"";
            resultado = Integer.toBinaryString(Integer.parseInt("-"+resultado));
            resultado = "-"+Integer.parseInt(resultado.substring(8), 2)+"";
        }else
            resultado = Integer.parseInt(resultado, 2)+"";

        return resultado;
    }
}
