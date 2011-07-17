package com.emergn.chedley;

import java.text.DecimalFormat;

public class NumberRangeParser {

    public final static NumberRangeParser HUNDRED_RANGE_PARSER = new NumberRangeParser(
	    NumberRange.HUNDRED);
    public final static NumberRangeParser HUNDRED_THOUSAND_RANGE_PARSER = new NumberRangeParser(
	    NumberRange.HUNDRED_THOUSAND);
    public final static NumberRangeParser MILLION_RANGE_PARSER = new NumberRangeParser(
	    NumberRange.MILLION);

    private final String mask = "000000000";
    private final DecimalFormat numberFormat = new DecimalFormat(mask);
    private final NumberRange range;

    public NumberRangeParser(NumberRange range) {
	this.range = range;
    }

    public Integer getRangeNumber(Integer number) {
	String formattedNumber = numberFormat.format(number);
	Integer millionNumber = Integer.parseInt(formattedNumber.substring(
		range.getStartINdex(), range.getEndIndex()));
	return millionNumber;
    }

    enum NumberRange {
	MILLION("million", 0, 3), HUNDRED_THOUSAND("thousand", 3, 6), HUNDRED(
		"", 6, 9);

	private final int endIndex;
	private final int startINdex;
	private final String description;

	private NumberRange(String description, int startINdex, int endIndex) {
	    this.description = description;
	    this.startINdex = startINdex;
	    this.endIndex = endIndex;
	}

	public int getEndIndex() {
	    return endIndex;
	}

	public int getStartINdex() {
	    return startINdex;
	}

	public String getDescription() {
	    return description;
	}
    }

    public String getRangeDescription() {
	return range.getDescription();
    }
}
