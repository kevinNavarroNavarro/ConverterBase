import puntoFlotante.Entero;
import puntoFlotante.Medium;

public class Main {

	public static void main(String[] args) {
		
		// Rango de los valores representables
		System.out.println("### Rango de valores representables ### \nRango -2^(23) hasta 2^(23)-1\n"
				+ "Rango: -8388608 hasta 8388607\n");
		
		Medium medium = new Medium();
		
		//Datos de prueba
		//Suma Decimales
		System.out.println("### Sumas Decimales ###");
		System.out.println("Operacion: 10 + 30");
		Medium s1 = new Medium("10");
		Medium s2 = new Medium("30");
		medium.setValor(Entero.suma(s1, s2).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: -13 + 113");
		Medium s3 = new Medium("-13");
		Medium s4 = new Medium("113");
		medium.setValor(Entero.suma(s3, s4).getValor());
		System.out.println(medium.toString());

		System.out.println("\n Operacion: 16000000 + 2000000");
		Medium s5 = new Medium("16000000");
		Medium s6 = new Medium("2000000");
		medium.setValor(Entero.suma(s5, s6).getValor());
		System.out.println(medium.toString());
		
		//Suma en Hexadecimal
		System.out.println("\n### Suma Hexadecimal ###");
		System.out.println("Operacion: cf + 1cb");
		Medium hs1 = new Medium("cf", "h");
		Medium hs2 = new Medium("1cb", "h");
		medium.setValor(Entero.suma(hs1, hs2).getValor());
		System.out.println(medium.toString());

		//Restas
		System.out.println("\n### Restas Decimales ###");
		System.out.println("Operacion: 402 - 602");
		Medium r1 = new Medium("402");
		Medium r2 = new Medium("602");
		medium.setValor(Entero.resta(r1, r2).getValor());
		System.out.println(medium.toString());

		System.out.println("\n Operacion: 512 - 256");
		Medium r5 = new Medium("512");
		Medium r6 = new Medium("256");
		medium.setValor(Entero.resta(r5, r6).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: 16000000 - 400000 *Desbordamiento*");
		Medium r3 = new Medium("16000000");
		Medium r4 = new Medium("400000");
		medium.setValor(Entero.resta(r3, r4).getValor());
		System.out.println(medium.toString());
		
		//Resta en Hexadecimal
		System.out.println("\n### Resta Hexadecimal ###");
		System.out.println("Operacion: f - a");
		Medium hr1 = new Medium("f", "h");
		Medium hr2 = new Medium("a", "h");
		medium.setValor(Entero.resta(hr1, hr2).getValor());
		System.out.println(medium.toString());


		//Multiplicacion
		System.out.println("\n### Multiplicaciones Decimales ###");
		System.out.println("Operacion: 11 * 111");
		Medium m1 = new Medium("11");
		Medium m2 = new Medium("111");
		medium.setValor(Entero.multiplicacion(m1, m2).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: 360 * -25");
		Medium m3 = new Medium("360");
		Medium m4 = new Medium("-25");
		medium.setValor(Entero.multiplicacion(m3, m4).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: 654 * 1000000 *Desbordamiento*");
		Medium m5 = new Medium("654");
		Medium m6 = new Medium("1000000");
		medium.setValor(Entero.multiplicacion(m5, m6).getValor());
		System.out.println(medium.toString());
		
		//Multiplicacion en Hexadecimal
		System.out.println("\n### Multiplicacion Hexadecimal ###");
		System.out.println("Operacion: e * e *Desbordamiento*");
		Medium hm1 = new Medium("e", "h");
		Medium hm2 = new Medium("e", "h");
		medium.setValor(Entero.multiplicacion(hm1, hm2).getValor());
		System.out.println(medium.toString());

		//Division
		System.out.println("\n### Divisiones Decimales ###");
		System.out.println("Operacion: 70/5");
		Medium d1 = new Medium("70");
		Medium d2 = new Medium("5");
		medium.setValor(Entero.division(d1, d2).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: 5/2");
		Medium d3 = new Medium("5");
		Medium d4 = new Medium("2");
		medium.setValor(Entero.division(d3, d4).getValor());
		System.out.println(medium.toString());

		System.out.println("\nOperacion: -625/-25");
		Medium d5 = new Medium("-625");
		Medium d6 = new Medium("-25");
		medium.setValor(Entero.division(d5, d6).getValor());
		System.out.println(medium.toString());
		
		//Division en Hexadecimal
		System.out.println("\n### Division Hexadecimal ###");
		System.out.println("Operacion: f/a");
		Medium hd1 = new Medium("f", "h");
		Medium hd2 = new Medium("a", "h");
		medium.setValor(Entero.division(hd1, hd2).getValor());
		System.out.println(medium.toString());

	}
}
