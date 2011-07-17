package com.emergn.chedley.vistors;

import static java.lang.String.format;

import com.emergn.chedley.NumberToStringMappingConstants;

//Should rename to GreaterThan20AndLessThan100NumericToStringVisitor
public class GreaterThan20NumericToStringVisitor implements
	NumericToStringVisitor {

    private NumericToStringVisitor lessThan20NumberVisitor;

    public GreaterThan20NumericToStringVisitor(
	    LessThan20NumericToStringVisitor lessThan20NumericToStringVisitor) {
	lessThan20NumberVisitor = lessThan20NumericToStringVisitor;
    }

    @Override
    public String getNumberAsString(Integer number) {

	String lessThan20Number = lessThan20NumberVisitor
		.getNumberAsString(number % 10);

	number = number / 10;

	String numberPronoun = getNumberPronoun(number % 10);

	return getFormatedString(lessThan20Number, numberPronoun);
    }

    private String getFormatedString(String lessThan20Number,
	    String numberPronoun) {
	if (numberPronoun == null) {
	    return format("%s", lessThan20Number);
	} else {
	    if (lessThan20Number.equals(NumberToStringMappingConstants.ZERO)) {
		return format("%s", numberPronoun);
	    }
	    return format("%s %s", numberPronoun, lessThan20Number);
	}
    }

    private String getNumberPronoun(int number) {
	return NumberToStringMappingConstants.numberPronounMapping.get(number);
    }

    @Override
    public boolean isInRange(Integer number) {
	return number > 19 && number < 100;
    }
}
