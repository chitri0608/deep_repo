package tdd.stringcal;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	public static int add(final String numbers) {
		String delimiter = ",|n";
		String numbersOnly = numbers;
		if (numbers.startsWith("//")) {
			int delIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delIndex, numbers.indexOf("n"));
			String[] value = delimiter.split("#");
			if (value.length > 1) {
				delimiter = "";
				for (int index = 0; index < value.length - 1; index++) {
					delimiter = delimiter + value[index] + "|";
				}
				delimiter = delimiter + value[value.length - 1];
			}
			numbersOnly = numbers.substring(numbers.indexOf("n") + 1);
		}
		return add(numbersOnly, delimiter);
	}

	private static int add(final String numbers, final String delimiter) {
		int value = 0;
		String[] numbersInArray = numbers.split(delimiter);
		List negNumbers = new ArrayList();
		for (String number : numbersInArray) {
			if (!number.trim().isEmpty()) {
				int checkNum = Integer.parseInt(number.trim());
				if (checkNum < 0) {
					negNumbers.add(checkNum);
				} else if (checkNum <= 1000) {
					value += checkNum;
				}
			}
		}
		if (negNumbers.size() > 0) {
			throw new RuntimeException("Negative Numbers are not allowed: " + negNumbers.toString());
		}
		return value;
	}
}
