package com.shubham.version2;

public class StringCalculatorV2 {

	public static int add(String number) {
		if (number.isEmpty()) {
			return 0;
		}else if (number.length()==1) {
			return intConverter(number);
		}
		return -1;
	}

	private static int intConverter(String num) {
		return Integer.parseInt(num);
	}

}
