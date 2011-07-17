package net.cghsystems.nwe;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import net.cghsystems.nwe.utils.Assertions;
import net.cghsystems.nwe.vistors.NumericToStringVisitor;


public class LessThan1000NumericToStringConverter implements
	NumberToStringConverter {

    private final List<NumericToStringVisitor> visitors = new ArrayList<NumericToStringVisitor>();

    public LessThan1000NumericToStringConverter(NumericToStringVisitor zeroStringVisitor,
	    NumericToStringVisitor lessThan20NumericToStringVisitor,
	    NumericToStringVisitor greaterThan20NumericToStringVisitor,
	    NumericToStringVisitor inHundredNumericToStringVisitor) {

	visitors.add(zeroStringVisitor);
	visitors.add(lessThan20NumericToStringVisitor);
	visitors.add(greaterThan20NumericToStringVisitor);
	visitors.add(inHundredNumericToStringVisitor);
    }

    public String findStringEqivalentForNumber(Integer number) {
	try {
	    return convertNumberToString(number);
	} catch (IllegalArgumentException iae) {
	    throw iae;
	} catch (Exception e) {
	    throw new RuntimeException(
		    format(
			    "There has been a terrible exception trying to convert %s in to a number",
			    number), e);
	}
    }

    private String convertNumberToString(Integer number) {
	Assertions.assertNotNull(number);
	String numberToReturn = "";
	for (NumericToStringVisitor visitor : visitors) {
	    if (visitor.isInRange(number)) {
		numberToReturn = visitor.getNumberAsString(number);
		break;
	    }
	}
	return numberToReturn.trim();
    }
}
