package main;
import tdd.stringcal.*;
import tdd.stringcaltest.*;
public class StringCalculatorMain {

	public static void main(String[] args) {
		 // return 0 for empty String
		System.out.println(StringCalculator.add(""));
		
		// return the single number
		System.out.println(StringCalculator.add("1"));
		
		// return sum of numbers separated by commas No exception
		System.out.println(StringCalculator.add("1,3"));
		
		// Throw Exception for Number more than 2 but later it removed
		System.out.println(StringCalculator.add("2,3,5"));
		
		// return Sum of all the Numbers
		System.out.println( StringCalculator.add("4,6,16,20,28,47"));
		
		// if n is used than also it will return Sum of all the Numbers
		System.out.println(StringCalculator.add("5,10n15"));
		
		//if delimiter is defined than according to that numbers are Differentiate and return sum
		System.out.println(StringCalculator.add("//;n5;10;15"));
		
		// if Numbers are Greater than 1000 then it will ignore that numbers
		System.out.println( StringCalculator.add("17,1024,1001,6,1165,1000"));
		
		//if Delimiter is of any Length than also it should take it
		System.out.println(StringCalculator.add("//;;;n5;;;10;;;15"));
		
		// if Multiple Delimiters than it Should work
		System.out.println( StringCalculator.add("//;#:#,n5;10,15"));
		
		// if negative Numbers than it will throw exception with the Numbers
		System.out.println(StringCalculator.add("5,-16,7,-22,65,13"));
				
		// Throw Exception for Number Format
	    System.out.println(StringCalculator.add("1,A"));
	}

}
