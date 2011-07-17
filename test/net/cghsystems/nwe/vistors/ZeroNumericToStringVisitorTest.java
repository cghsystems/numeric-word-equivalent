package net.cghsystems.nwe.vistors;

import static junit.framework.Assert.assertEquals;
import junit.framework.Assert;

import net.cghsystems.nwe.ZeroStringRepresentationStrategy;
import net.cghsystems.nwe.vistors.ZeroNumericToStringVisitor;

import org.junit.Before;
import org.junit.Test;


public class ZeroNumericToStringVisitorTest {

    private ZeroNumericToStringVisitor unit;

    @Before
    public void before() {
	this.unit = new ZeroNumericToStringVisitor(
		ZeroStringRepresentationStrategy.DISPLAY_ZERO);
    }

    @Test
    public void givenZeroAsAParmeterThenShouldReturnZeroString() {
	Assert.assertEquals("zero", unit.getNumberAsString(0));
    }

    @Test
    public void givenZeroAsAParmeterAndAZeroStringDisplayStrategyOfNoDiaplyThenShouldReturnZeroLengthString() {
	ZeroStringRepresentationStrategy strategy = ZeroStringRepresentationStrategy.DO_NOT_DISPLAY_ZERO;
	this.unit = new ZeroNumericToStringVisitor(strategy);
	assertEquals(strategy.getStringDisplay(), unit.getNumberAsString(0));
    }

    @Test
    public void givenZeroAsParmeterThenInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(0));
    }

    @Test
    public void givenGreaterThanZeroAsParmeterThenInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(1));
    }

    @Test
    public void givenLessThanZeroAsParmeterThenInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(-1));
    }

}
