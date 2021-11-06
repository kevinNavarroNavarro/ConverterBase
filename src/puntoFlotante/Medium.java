package puntoFlotante;

import java.util.Arrays;

public class Medium {

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

    //Convierte los numeros hexadecimales a decimales
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
//        binario =  ceros + binario;

        return binario;
    }

    //Complementa los numeros decimales (solamente negativos)
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
            // Recorto a 24 bits
            binario = binario.substring(8);
        }

        return binario;
    }

    //getValor
    public Byte[] getValor() {
        return valor;
    }
    
    //setValor
    public void setValor(Byte[] valor) {
        this.valor = valor;
    }

    //toString()
    @Override
    public String toString() {
    	String binario = resultadoBinario(valor);
        String decimal = resultadoDecimal(valor);
        String hexadecimal = resultadoHexadecimal(valor);
        return "Medium {" + Arrays.toString(valor) + '}'+ 
        		"\nValor binario: " +binario +
        		"\nValor decimal: " +decimal +
        		"\nValor hexadecimal: " +hexadecimal;
    }
    
    
  //Mostrar resultado en hexadecimal
    private static String resultadoBinario(Byte[] byteArray){
        String resultado = "";

        for(int i=0;i<3;i++){
            resultado+= Entero.obtenerBinario(byteArray[i]+"");
        }

        return resultado;
    }

    //Mostrar resultado en decimal
    private static String resultadoDecimal(Byte[] byteArray){
        String resultado = "";

        for(int i=0;i<3;i++){
            resultado+= Entero.obtenerBinario(byteArray[i]+"");
        }

        if(resultado.charAt(0)=='1'){
            resultado = Integer.parseInt(resultado, 2)+"";
            resultado = Integer.toBinaryString(Integer.parseInt("-"+resultado));
            resultado = "-"+Integer.parseInt(resultado.substring(8), 2)+"";
        }else
            resultado = Integer.parseInt(resultado, 2)+"";

        return resultado;
    }
    
    //Mostrar resultado en hexadecimal
    private static String resultadoHexadecimal(Byte[] byteArray){
        String resultado = "";
        int resultadoDecimal = 0;

        for(int i=0;i<3;i++){
            resultado+= Entero.obtenerBinario(byteArray[i]+"");
        }

        resultadoDecimal = Integer.parseInt(resultado, 2);
        resultado = Integer.toHexString(resultadoDecimal)+"";
     
        String ceros = "";
        for (int i = resultado.length(); i < 6; i++) {
        	ceros += "0";
        }
        resultado = ceros + resultado + "H";

        return resultado;
    }
}
