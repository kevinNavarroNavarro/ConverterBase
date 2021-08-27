
import calculatorConverter.CalculartorConverter;

public class Main {

	public static void main(String[] args) { 
	
		CalculartorConverter calculatorConverter = new CalculartorConverter();
		
		// Test calculatorConverter
		System.out.print("TEST CALCULATOR CONVERTER BASE 1O\n");
		System.out.print("Base: 5, número: 12.4, conversión a base 10: " + calculatorConverter.converterABaseTen("12.4", 5)+"\n");
		
		System.out.print("Base: 5, número: 423.1, conversión a base 10: " + calculatorConverter.converterABaseTen("423.1", 5)+"\n");
		
		System.out.print("Base: 16, número: A, conversión a base 10: " + calculatorConverter.converterABaseTen("A", 16)+"\n");
		
		System.out.print("Base: 16, número: BA54.2, conversión a base 10: " + calculatorConverter.converterABaseTen("BA54.2", 16)+"\n");
		
		System.out.print("Base: 8, número: 752.1, conversión a base 10: " + calculatorConverter.converterABaseTen("752.1", 8)+"\n");
		
	}

}
