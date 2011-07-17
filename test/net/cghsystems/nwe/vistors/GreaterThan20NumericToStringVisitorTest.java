package net.cghsystems.nwe.vistors;

import static org.easymock.EasyMock.createMock;
import junit.framework.Assert;

import net.cghsystems.nwe.vistors.GreaterThan20NumericToStringVisitor;
import net.cghsystems.nwe.vistors.LessThan20NumericToStringVisitor;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class GreaterThan20NumericToStringVisitorTest {

    private GreaterThan20NumericToStringVisitor unit;
    private LessThan20NumericToStringVisitor lessThan20NumericToStringVisitor;

    @Before
    public void before() {
	lessThan20NumericToStringVisitor = createMock(LessThan20NumericToStringVisitor.class);
	unit = new GreaterThan20NumericToStringVisitor(
		lessThan20NumericToStringVisitor);
    }

    @Test
    public void givenAnInputParameterOf45ThenGetNumberAsStringShouldReturnFourtyFiveAsString() {
	EasyMock.expect(lessThan20NumericToStringVisitor.getNumberAsString(5))
		.andReturn("five");

	EasyMock.replay(lessThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(45);
	Assert.assertEquals("fourty five", actual);
	EasyMock.verify(lessThan20NumericToStringVisitor);
    }

    @Test
    public void givenAnInputParameterO105ThenGetNumberAsStringShouldReturnFourtyFiveAsString() {
	EasyMock.expect(lessThan20NumericToStringVisitor.getNumberAsString(5))
		.andReturn("five");

	EasyMock.replay(lessThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(105);
	Assert.assertEquals("five", actual);
	EasyMock.verify(lessThan20NumericToStringVisitor);
    }

    @Test
    public void givenAnInputParameterOf40ThenGetNumberAsStringShouldReturnFourtyFiveAsString() {
	EasyMock.expect(lessThan20NumericToStringVisitor.getNumberAsString(0))
		.andReturn("zero");

	EasyMock.replay(lessThan20NumericToStringVisitor);
	String actual = unit.getNumberAsString(40);
	Assert.assertEquals("fourty", actual);
	EasyMock.verify(lessThan20NumericToStringVisitor);
    }

    @Test
    public void givenANumberOfLessThan20ThenNumberIsInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(3));
    }

    @Test
    public void givenANumberThenNumberIsInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(20));
    }

    @Test
    public void givenANumberOfGreaterThan20ThenNumberIsInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(21));
    }

    @Test
    public void givenANumberOfGreaterThan100ThenNumberIsInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(100));
    }

    @Test
    public void givenANumberOf99ThenNumberIsInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(99));
    }
}
