package net.cghsystems.nwe.ioc;

import static net.cghsystems.nwe.ZeroStringRepresentationStrategy.DISPLAY_ZERO;
import net.cghsystems.nwe.LessThan1000NumericToStringConverter;
import net.cghsystems.nwe.vistors.GreaterThan20NumericToStringVisitor;
import net.cghsystems.nwe.vistors.InHundredNumericToStringVisitor;
import net.cghsystems.nwe.vistors.LessThan20NumericToStringVisitor;
import net.cghsystems.nwe.vistors.ZeroNumericToStringVisitor;


/**
 * Simple container that allows Inversion of Control pattern to be applied
 * across LessThan1000NumericToStringConverter classes.
 */
public class LessThan1000NumericToStringConverterBuilder implements
	Builder<LessThan1000NumericToStringConverter> {

    public LessThan1000NumericToStringConverter build() {

	ZeroNumericToStringVisitor displayZeroStringVisitor = new ZeroNumericToStringVisitor(
		DISPLAY_ZERO);

	LessThan20NumericToStringVisitor lessThan20NumericToStringVisitor = new LessThan20NumericToStringVisitor();

	GreaterThan20NumericToStringVisitor greaterThan20NumericToStringVisitor = new GreaterThan20NumericToStringVisitor(
		lessThan20NumericToStringVisitor);

	InHundredNumericToStringVisitor inHundredNumericToStringVisitor = new InHundredNumericToStringVisitor(
		lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);

	LessThan1000NumericToStringConverter numericToString = new LessThan1000NumericToStringConverter(
		displayZeroStringVisitor, lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor,
		inHundredNumericToStringVisitor);

	return numericToString;

    }
}
