package net.cghsystems.nwe;

import java.util.Scanner;

import net.cghsystems.nwe.ioc.ClassIntances;


public class Main {

    private DefaultNumberToStringConverter converter;

    public static void main(String[] args) {
	Main main = new Main();
	main.init();
	main.go();
	System.exit(0);
    }

    private void init() {
	converter = ClassIntances.DEFAUL_NUMBER_TO_STRING_CONVERTER;
    }

    // Messy bit of Procedure for command line gui
    private void go() {
	while (true) {
	    System.out
		    .println("Please enter an integer to convert in to a string. (type 'q' to quit)");
	    String toConvert = getToConvert();

	    if (toConvert.equals("q")) {
		System.out.println("bye bye");
		break;
	    }

	    if (isNotInstanceOfInteger(toConvert)) {
		displayNonIntegerInputErrorMessage();
	    } else {
		displayConvertedResult(toConvert);
	    }
	}
    }

    private void displayNonIntegerInputErrorMessage() {
	System.out.println("Please only enter whole integer values");
    }

    private void displayConvertedResult(String toConvert) {
	String converted = converter
		.findStringEqivalentForNumber(Integer
			.valueOf(toConvert));
	System.out.println("Result: " + converted);
    }

    // Would never usually use an exception to test a condition not sure how to
    // test if a string is an integer any other way tho!!
    private boolean isNotInstanceOfInteger(String toConvert) {
	try {
	    Integer.valueOf(toConvert);
	    return false;
	} catch (Exception e) {
	    return true;
	}
    }

    private String getToConvert() {
	Scanner scanner = new Scanner(System.in);
	return scanner.nextLine();
    }
}
