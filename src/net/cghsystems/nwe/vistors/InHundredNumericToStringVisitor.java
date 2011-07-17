package net.cghsystems.nwe.vistors;

import static java.lang.String.format;

public class InHundredNumericToStringVisitor implements NumericToStringVisitor {

    private NumericToStringVisitor lessThan20NumberVisitor;

    private NumericToStringVisitor greaterThan20NumberVisitor;

    public InHundredNumericToStringVisitor(
	    NumericToStringVisitor lessThan20NumericToStringVisitor,
	    NumericToStringVisitor greaterThan20NumericToStringVisitor) {
	lessThan20NumberVisitor = lessThan20NumericToStringVisitor;
	greaterThan20NumberVisitor = greaterThan20NumericToStringVisitor;
    }

    @Override
    public String getNumberAsString(Integer number) {
	if (number % 100 == 0) {
	    String multiple = lessThan20NumberVisitor
		    .getNumberAsString(number / 100);
	    return format("%s hundred", multiple);
	} else {
	    String twenty = greaterThan20NumberVisitor
		    .getNumberAsString(number % 100);
	    String multiple = lessThan20NumberVisitor
		    .getNumberAsString(number / 100);
	    return format("%s hundred and %s", multiple, twenty);
	}
    }

    @Override
    public boolean isInRange(Integer number) {
	return number > 99;
    }
}
