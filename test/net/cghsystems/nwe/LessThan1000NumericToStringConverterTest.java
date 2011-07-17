package net.cghsystems.nwe;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.cghsystems.nwe.LessThan1000NumericToStringConverter;
import net.cghsystems.nwe.ioc.LessThan1000NumericToStringConverterBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class LessThan1000NumericToStringConverterTest {

    private static LessThan1000NumericToStringConverter unit;

    @RunWith(Parameterized.class)
    // Needed to prevent Junit test runner from running the non paramterized
    // unit tests for each parameter
    public static class ParamterizedTests {

	private Integer inputInteger;

	private String expectedOutputString;

	public ParamterizedTests(Integer inputInteger,
		String expectedOutoutString) {
	    this.expectedOutputString = expectedOutoutString;
	    this.inputInteger = inputInteger;
	}

	@Before
	public void before() {
	    unit = new LessThan1000NumericToStringConverterBuilder().build();
	}

	@Parameters
	public static Collection<Object[]> data() {
	    return Arrays.asList(new Object[][] { { 0, "zero" }, { 1, "one" },
		    { 2, "two" }, { 3, "three" }, { 4, "four" }, { 5, "five" },
		    { 6, "six" }, { 7, "seven" }, { 8, "eight" },
		    { 9, "nine" }, { 10, "ten" }, { 11, "eleven" },
		    { 12, "twelve" }, { 13, "thirteen" }, { 14, "fourteen" },
		    { 15, "fifteen" }, { 16, "sixteen" }, { 17, "seventeen" },
		    { 18, "eighteen" }, { 19, "nineteen" }, { 20, "twenty" },
		    { 21, "twenty one" }, { 32, "thirty two" },
		    { 43, "fourty three" }, { 54, "fifty four" },
		    { 65, "sixty five" }, { 76, "seventy six" },
		    { 87, "eighty seven" }, { 98, "ninety eight" },
		    { 29, "twenty nine" }, { 30, "thirty" }, { 40, "fourty" },
		    { 100, "one hundred" }, { 105, "one hundred and five" } });
	}

	@Test
	public void givenInputIntegerThenShouldReturnExpdectedOutputString() {
	    String actual = unit.findStringEqivalentForNumber(inputInteger);
	    assertEquals(expectedOutputString, actual);
	}
    }

    @Before
    public void before() {
	unit = new LessThan1000NumericToStringConverterBuilder().build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenaNullInputIntegerThenShouldThrowIllegalArgumentException() {
	unit.findStringEqivalentForNumber(null);
    }
}
