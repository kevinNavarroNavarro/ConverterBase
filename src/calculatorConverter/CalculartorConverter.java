package calculatorConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculartorConverter {
	
	// Convert a base number 2-16 to a base number 10
	public String converterABaseTen(String numBaseX, int originBase) {
		
		int exponent = 0;
		String decimalsNum="";
		
		// Divide the string by .
		String[] parts = numBaseX.split(Pattern.quote("."));
		String intNum = parts[0];
		
		// If inputNum have .
		if(parts.length>1) {
			decimalsNum = parts[1];
			exponent = numBaseX.indexOf(".") - 1;
		}
		
		// inputNum without .
		String num = intNum.concat(decimalsNum);
		
		
		double intResult = 0; 
		
		// Converter inputNum to base 10
		for(int i=0; i<num.length();i++) {
			String character = num.substring(i, i+1);
			
			intResult += (getValue(character) * Math.pow(originBase,exponent));
			exponent--;
		}
		
		return intResult+"";
	}
	
	// Character is converter to num
	public static int getValue(String digit) {
		
		int value;
		
		switch (digit) {
		case "A": 
			value = 10;
			break;
		case "B":
			value = 11;
			break;
		case "C":
			value = 12;
			break;
		case "D": 
			value = 13;
			break;
		case "E": 
			value = 14;
			break;
		case "F": 
			value = 15;
			break;
		default: 
			value = Integer.parseInt(digit);
		};
		
		return value;
	}
	
	
	
	//Cambio de base 10 a base X-------------------------------------
	private String convierteParteEntera(String parteEntera,int baseDestino) {
		String result = "";
		int numToConvert = Integer.parseInt(parteEntera);
        List<Integer> intArray = new ArrayList<Integer>();
		
        //division to get new base
		while(numToConvert >= baseDestino ) {
			intArray.add(numToConvert % baseDestino);
			numToConvert = numToConvert/baseDestino;
			if(numToConvert < baseDestino) {
				intArray.add(numToConvert);
			}
		}
		//invert arrayList 
		for (int i = (intArray.size()-1); i >= 0 ; i--) {
			//the value is hexadecimal
			if(intArray.get(i)>9) {
				result += hexadecimalValue(intArray.get(i));
			}else
				result += intArray.get(i);		
		}	
		return result;	
	}
	
	
	private String convierteParteFraccion(String parteFraccion,int baseDestino, int numDigitos) {
		String result = "";
		String decimalsNum="";
		String numToConvert =  "";
		String exponent = "";
		double div = Double.parseDouble(parteFraccion);
		int count = 1;
		
		//multiplication to get the new decimal base
		while ( count <= numDigitos  &&  !decimalsNum.equals("0")) {		
			numToConvert = "" + (div*baseDestino);			
			String[] parts = numToConvert.split(Pattern.quote("."));
			exponent = parts[0];
			decimalsNum = parts[1];
			
			//the value is hexadecimal
			int intExponent = Integer.parseInt(exponent);
			if(intExponent>9) {
				result += hexadecimalValue(intExponent);
			}else
				result+=exponent;			
			div = Double.parseDouble("0."+decimalsNum);
			count++;
		}	
		return result;	
	}
	
	public String convierteDeBaseDiez(String numero,int baseDestino,int numDigitos) {
		String result = "";
		String[] parts = numero.split(Pattern.quote("."));
		
		//has decimals
		if(parts.length>1) {
			String exponent = parts[0];
			String decimalsNum = "0."+parts[1];
			result += convierteParteEntera(exponent, baseDestino);
			result += ".";
			result += convierteParteFraccion(decimalsNum, baseDestino, numDigitos);
		}else
			result += convierteParteEntera(numero, baseDestino);
		return result;	
	}
	
	//method hexadecimal value
	private String hexadecimalValue(int num) {
		String result = "";
		switch (num) {
		case 10: result += "A";
			break;
		case 11: result += "B";
			break;
		case 12:  result += "C";
			break;
		case 13: result += "D";
			break;
		case 14: result += "E";
			break;
		case 15: result += "F";
			break;
		};	
		
		return result;
	}

	public String cambioDeBase(String numero, int baseOrigen, int baseDestino, int numDigitos) {
		//Paso el número a base 10
		String numeroConvertido = "";
		numeroConvertido = converterABaseTen(numero, baseOrigen);

		//Paso el número a la base origen. En caso de ser la base destino 10, no lo hace
		if (baseDestino != 10){
			numeroConvertido = convierteDeBaseDiez(numeroConvertido, baseDestino, numDigitos);
		}

		return numeroConvertido;
	}
	
}
