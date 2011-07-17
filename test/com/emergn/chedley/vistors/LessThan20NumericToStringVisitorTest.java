package com.emergn.chedley.vistors;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class LessThan20NumericToStringVisitorTest {

    private static LessThan20NumericToStringVisitor unit;

    @Before
    public void before() {
	unit = new LessThan20NumericToStringVisitor();
    }

    // Needed to prevent Junit test runner from running the non paramterized
    // unit tests for each parameter
    @RunWith(Parameterized.class)
    public static final class ParameterizedTests {

	private Integer inputInteger;

	private String expectedOutputString;

	public ParameterizedTests(Integer inputInteger,
		String expectedOutputString) {
	    this.inputInteger = inputInteger;
	    this.expectedOutputString = expectedOutputString;
	}

	@Before
	public void before() {
	    unit = new LessThan20NumericToStringVisitor();
	}

	@Parameters
	public static Collection<Object[]> data() {
	    return Arrays.asList(new Object[][] { { 0, "zero" }, { 1, "one" },
		    { 2, "two" }, { 3, "three" }, { 4, "four" }, { 5, "five" },
		    { 6, "six" }, { 7, "seven" }, { 8, "eight" },
		    { 9, "nine" }, { 10, "ten" }, { 11, "eleven" },
		    { 12, "twelve" }, { 13, "thirteen" }, { 14, "fourteen" },
		    { 15, "fifteen" }, { 16, "sixteen" }, { 17, "seventeen" },
		    { 18, "eighteen" }, { 19, "nineteen" } });
	}

	@Test
	public void givenInputIntegerThenShouldReturnExpdectedOutputString() {
	    String actual = unit.getNumberAsString(inputInteger);
	    assertEquals(expectedOutputString, actual);
	}
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenANumberOUtOfRangeThenIllegalArgumentShouldBeThrown() {
	unit.getNumberAsString(20);
    }

    @Test
    public void givenANumberOfLessThan20ThenNumberIsInRangeShouldReturnTrue() {
	Assert.assertTrue(unit.isInRange(3));
    }

    @Test
    public void givenANumberThenNumberIsInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(20));
    }

    @Test
    public void givenANumberOfGreaterThan20ThenNumberIsInRangeShouldReturnFalse() {
	Assert.assertFalse(unit.isInRange(21));
    }
}
