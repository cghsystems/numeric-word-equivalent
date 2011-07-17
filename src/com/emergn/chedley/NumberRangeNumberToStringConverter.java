package com.emergn.chedley;

public class NumberRangeNumberToStringConverter implements
	NumberToStringConverter {

    private final NumberRangeParser parser;

    private final NumberToStringConverter lessThan1000NumericToStringConverter;

    public NumberRangeNumberToStringConverter(NumberRangeParser parser,
	    NumberToStringConverter lessThan1000NumericToStringConverter) {
	this.parser = parser;
	this.lessThan1000NumericToStringConverter = lessThan1000NumericToStringConverter;
    }

    @Override
    public String findStringEqivalentForNumber(Integer number) {

	Integer rangeNumber = parser.getRangeNumber(number);
	String string = lessThan1000NumericToStringConverter
		.findStringEqivalentForNumber(rangeNumber);

	if (isZero(string)) {
	    return "";
	}

	String ret = string + " " + parser.getRangeDescription();
	return ret.trim();
    }

    public boolean isZero(String string) {
	return string.equals(ZeroStringRepresentationStrategy.DISPLAY_ZERO
		.getStringDisplay());
    }
}
