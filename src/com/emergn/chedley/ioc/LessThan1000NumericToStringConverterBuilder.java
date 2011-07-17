package com.emergn.chedley.ioc;

import static com.emergn.chedley.ZeroStringRepresentationStrategy.DISPLAY_ZERO;

import com.emergn.chedley.LessThan1000NumericToStringConverter;
import com.emergn.chedley.vistors.GreaterThan20NumericToStringVisitor;
import com.emergn.chedley.vistors.InHundredNumericToStringVisitor;
import com.emergn.chedley.vistors.LessThan20NumericToStringVisitor;
import com.emergn.chedley.vistors.ZeroNumericToStringVisitor;

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
