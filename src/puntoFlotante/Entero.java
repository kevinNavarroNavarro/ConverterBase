package puntoFlotante;

import javax.sql.rowset.serial.SerialArray;
import java.sql.Array;

public class Entero {

    public static Medium suma(Medium valor1, Medium valor2){
        Medium resultado = new Medium();
        Byte[] byteArray = new Byte[3];
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        String sumaFinal = "";

        String binario1 = "";
        String binario2 = "";

        for(int i=0;i<3;i++){
            binario1+= obtenerBinario(valor1.getValor()[i]+"");
            binario2+= obtenerBinario(valor2.getValor()[i]+"");
        }

        num1 = Integer.parseInt(binario1, 2);
        num2 = Integer.parseInt(binario2, 2);
        sum = num1+ num2;


        sumaFinal = Integer.toString(sum, 2);

        if(sumaFinal.length()>24){
            sumaFinal = sumaFinal.substring(sumaFinal.length()-24);
        }else{
            sumaFinal = agregarCeros(sumaFinal);
        }


        resultado.setValor(determinarSigno(sumaFinal));

       return resultado;
    }

    public static Medium resta(Medium valor1, Medium valor2){
        Medium resultado = new Medium();
        Byte[] byteArray = new Byte[3];
        int num1 = 0;
        int num2 = 0;
        int resta = 0;
        String restaFinal = "";

        String binario1 = "";
        String binario2 = "";

        for(int i=0;i<3;i++){
            binario1+= obtenerBinario(valor1.getValor()[i]+"");
            binario2+= obtenerBinario(valor2.getValor()[i]+"");
        }

        num1 = Integer.parseInt(binario1, 2);
        num2 = Integer.parseInt(binario2, 2);
        resta = num1 - num2;

        restaFinal = Integer.toBinaryString(Integer.parseInt(resta+""));

        if(restaFinal.length()>24){
            restaFinal = restaFinal.substring(restaFinal.length()-24);
        }else{
            restaFinal = agregarCeros(restaFinal);
        }

        resultado.setValor(determinarSigno(restaFinal));


        return resultado;
    }

    public static Medium multiplicacion(Medium valor1, Medium valor2){
        Medium resultado = new Medium();
        Byte[] byteArray = new Byte[3];
        int num1 = 0;
        int num2 = 0;
        int multiplicacion = 0;
        String multiplicacionFinal = "";

        String binario1 = "";
        String binario2 = "";

        for(int i=0;i<3;i++){
            binario1+= obtenerBinario(valor1.getValor()[i]+"");
            binario2+= obtenerBinario(valor2.getValor()[i]+"");
        }

        num1 = Integer.parseInt(binario1, 2);
        num2 = Integer.parseInt(binario2, 2);
        multiplicacion = num1 * num2;


        multiplicacionFinal = Integer.toString(multiplicacion, 2);
        if(multiplicacionFinal.length()>24){
            multiplicacionFinal = multiplicacionFinal.substring(multiplicacionFinal.length()-24);
        }else{
            multiplicacionFinal = agregarCeros(multiplicacionFinal);
        }

        resultado.setValor(determinarSigno(multiplicacionFinal));

        return resultado;
    }

    public Medium division(Medium valor1, Medium valor2){
        Medium resultado = new Medium();
        Byte[] byteArray = new Byte[3];
        int num1 = 0;
        int num2 = 0;
        int division = 0;
        String divisionFinal = "";

        String binario1 = "";
        String binario2 = "";

        for(int i=0;i<3;i++){
            binario1+= obtenerBinario(valor1.getValor()[i]+"");
            binario2+= obtenerBinario(valor2.getValor()[i]+"");
        }
        boolean esNegativo = false;
        if(binario1.charAt(0)=='1'){
            binario1 = complementoDivision(binario1);
            esNegativo = true;
        }
        if(binario2.charAt(0)=='1'){
            binario2 = complementoDivision(binario2);
            esNegativo = true;
        }

        num1 = Integer.parseInt(binario1, 2);
        num2 = Integer.parseInt(binario2, 2);


        division = num1 / num2;


        //divisionFinal = Integer.toString(division, 2);
        divisionFinal = Integer.toBinaryString(Integer.parseInt(division+""));

        if(divisionFinal.length()>24){
            divisionFinal = divisionFinal.substring(divisionFinal.length()-24);
        }else{
            divisionFinal = agregarCeros(divisionFinal);
        }

        if (esNegativo){
            divisionFinal = "1"+divisionFinal.substring(1);
        }

        System.out.println(divisionFinal.length()+" tamaño division");
        resultado.setValor(determinarSigno(divisionFinal));

        return resultado;
    }

    //metodo para obtener la cadena de binarios
    public static String obtenerBinario(String valor) {
        String binario = "";
        boolean esNegativo = false;

        if ((valor.charAt(0)) == '-') {
            valor = valor.substring(1);
            esNegativo = true;
        }
        binario = Integer.toBinaryString(Integer.parseInt(valor));
        String ceros = "";

        for (int i = binario.length(); i < 8; i++) {
            if(esNegativo){
                ceros += "1";
                esNegativo = false;
            }else
            ceros += "0";
        }

        binario = ceros + binario;

        //System.out.println("binario: " + binario + " : " + binario.length() + " bits");

        return binario;
    }

    //metodo para determinar el signo
    private static Byte[] determinarSigno(String valor){
        Byte[] resultado = new Byte[3];

        if (valor.charAt(0) == '1') {
            resultado[0] = Byte.parseByte("-" + Integer.parseInt(valor.substring(1, 8), 2));
        } else {

            resultado[0] = Byte.parseByte("" + Integer.parseInt(valor.substring(1, 8), 2));
        }

        if (valor.charAt(8) == '1') {
            resultado[1] = Byte.parseByte("-" + Integer.parseInt(valor.substring(9, 16), 2));
        } else {

            resultado[1] = Byte.parseByte("" + Integer.parseInt(valor.substring(9, 16), 2));
        }

        if (valor.charAt(16) == '1') {

            resultado[2] = Byte.parseByte("-" + Integer.parseInt(valor.substring(17), 2));

        } else {
            resultado[2] = Byte.parseByte("" + Integer.parseInt(valor.substring(17), 2));
        }

        return resultado;
    }

    private static String agregarCeros (String dato){
        String ceros = "";

        for (int i = dato.length(); i < 24; i++) {
            ceros += "0";
        }
        dato = ceros+dato;

        return dato;
    }

    private static String complementoDivision(String dato){
        int posicion = 0;
        String temp = dato;
        for(int i = dato.length()-1; i >= 0; i--){
            if(dato.charAt(i)=='1'){
                posicion = i;
                break;
            }
        }

        dato = dato.substring(1,posicion).replaceAll("1","s");
        dato = dato.replaceAll("0","1");
        dato = dato.replaceAll("s","0");
        dato = dato + temp.substring(posicion);

        return dato;
    }
}
