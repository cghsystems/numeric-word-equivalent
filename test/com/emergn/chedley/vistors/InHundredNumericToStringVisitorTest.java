package com.emergn.chedley.vistors;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class InHundredNumericToStringVisitorTest {

    private InHundredNumericToStringVisitor unit;
    private NumericToStringVisitor lessThan20NumericToStringVisitor;
    private NumericToStringVisitor greaterThan20NumericToStringVisitor;

    @Before
    public void before() {
	lessThan20NumericToStringVisitor = EasyMock
		.createMock(LessThan20NumericToStringVisitor.class);

	greaterThan20NumericToStringVisitor = EasyMock
		.createMock(GreaterThan20NumericToStringVisitor.class);

	unit = new InHundredNumericToStringVisitor(
		lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);
    }

    @Test
    public void givenANumberOf100ThenGetNumberAsStringShouldReturnOneHundredAsString() {
	EasyMock.expect(lessThan20NumericToStringVisitor.getNumberAsString(1))
		.andReturn("one");
	replay(lessThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(100);
	verify(lessThan20NumericToStringVisitor);
	assertEquals("one hundred", actual);
    }

    @Test
    public void givenANumberOf105ThenGetNumberAsStringShouldReturnOneHundredAndFiveAsString() {
	expect(lessThan20NumericToStringVisitor.getNumberAsString(1))
		.andReturn("one");
	expect(greaterThan20NumericToStringVisitor.getNumberAsString(5))
		.andReturn("five");
	replay(lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(105);
	verify(lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);
	assertEquals("one hundred and five", actual);
    }

    @Test
    public void givenANumberOf266ThenGetNumberAsStringShouldReturnOneHundredAndFiveAsString() {
	expect(lessThan20NumericToStringVisitor.getNumberAsString(2))
		.andReturn("two");
	expect(greaterThan20NumericToStringVisitor.getNumberAsString(66))
		.andReturn("sixty six");
	replay(lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(266);
	verify(lessThan20NumericToStringVisitor,
		greaterThan20NumericToStringVisitor);
	assertEquals("two hundred and sixty six", actual);
    }

    @Test
    public void givenANumberOfLessThan100ThenNumberIsInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(3));
    }

    @Test
    public void givenANumberThenNumberIEqualTonRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(100));
    }

    @Test
    public void givenANumberOfGreaterThan100ThenNumberIsInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(101));
    }
}
