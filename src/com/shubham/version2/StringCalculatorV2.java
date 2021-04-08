package com.shubham.version2;

public class StringCalculatorV2 {

	public static int add(String number) {
		if (number.isEmpty()) {
			return 0;
		}else if (number.length()==1) {
			return intConverter(number);
		}else {
			String[] numerical = splitStr(number,",");
			return intConverter(numerical[0]) + intConverter(numerical[1]);
		}
		
	}

	private static String[] splitStr(String str, String expr) {
		return str.split(expr);
	}

	private static int intConverter(String num) {
		return Integer.parseInt(num);
	}

}
