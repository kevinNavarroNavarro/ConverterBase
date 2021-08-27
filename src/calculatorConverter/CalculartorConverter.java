package calculatorConverter;

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
	
}
