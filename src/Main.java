
import calculatorConverter.CalculartorConverter;
import puntoFlotante.Entero;
import puntoFlotante.Medium;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Entero e = new Entero();
		Medium medium = new Medium();
		//Datos de prueba
		//suma
		System.out.println("Sumas Decimales");
		System.out.println("10+30");
		Medium s1 = new Medium("10");
		Medium s2 = new Medium("30");
		medium.setValor(e.suma(s1, s2).getValor());
		System.out.println(medium.toString());

		System.out.println("\n-13+113");
		Medium s3 = new Medium("-13");
		Medium s4 = new Medium("113");
		medium.setValor(e.suma(s3, s4).getValor());
		System.out.println(medium.toString());

		System.out.println("\n16000000+2000000");
		Medium s5 = new Medium("16000000");
		Medium s6 = new Medium("2000000");
		medium.setValor(e.suma(s5, s6).getValor());
		System.out.println(medium.toString());

		//restas
		System.out.println("\n\nRestas Decimales");
		System.out.println("402-602");
		Medium r1 = new Medium("402");
		Medium r2 = new Medium("602");
		medium.setValor(e.resta(r1, r2).getValor());
		System.out.println(medium.toString());

		System.out.println("\n512-256");
		Medium r5 = new Medium("512");
		Medium r6 = new Medium("256");
		medium.setValor(e.resta(r5, r6).getValor());
		System.out.println(medium.toString());

		System.out.println("\n16000000-400000 *Desbordamiento*");
		Medium r3 = new Medium("16000000");
		Medium r4 = new Medium("400000");
		medium.setValor(e.resta(r3, r4).getValor());
		System.out.println(medium.toString());


		//Multiplicacion
		System.out.println("\n\nMultiplicaciones Decimales");
		System.out.println("11*111");
		Medium m1 = new Medium("11");
		Medium m2 = new Medium("111");
		medium.setValor(e.multiplicacion(m1, m2).getValor());
		System.out.println(medium.toString());

		System.out.println("\n360*-25");
		Medium m3 = new Medium("360");
		Medium m4 = new Medium("-25");
		medium.setValor(e.multiplicacion(m3, m4).getValor());
		System.out.println(medium.toString());

		System.out.println("\n654*1000000 *Desbordamiento*");
		Medium m5 = new Medium("654");
		Medium m6 = new Medium("1000000");
		medium.setValor(e.multiplicacion(m5, m6).getValor());
		System.out.println(medium.toString());

		//division
		System.out.println("\n\nDivisiones Decimales");
		System.out.println("70/5");
		Medium d1 = new Medium("70");
		Medium d2 = new Medium("5");
		medium.setValor(e.division(d1, d2).getValor());
		System.out.println(medium.toString());

		System.out.println("\n5/2");
		Medium d3 = new Medium("5");
		Medium d4 = new Medium("2");
		medium.setValor(e.division(d3, d4).getValor());
		System.out.println(medium.toString());

		System.out.println("\n-625/-25");
		Medium d5 = new Medium("-625");
		Medium d6 = new Medium("-25");
		medium.setValor(e.division(d5, d6).getValor());
		System.out.println(medium.toString());







	}

}
