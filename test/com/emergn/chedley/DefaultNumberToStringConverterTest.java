package com.emergn.chedley;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.emergn.chedley.ioc.DefaultNumberToStringConverterBuilder;

@RunWith(Parameterized.class)
public class DefaultNumberToStringConverterTest {

    private DefaultNumberToStringConverter unit;

    private Integer inputInteger;

    private String expectedOutputString;

    public DefaultNumberToStringConverterTest(Integer inputInteger,
	    String expectedOutputString) {
	this.inputInteger = inputInteger;
	this.expectedOutputString = expectedOutputString;
    }

    @Parameters
    public static Collection<Object[]> data() {
	return Arrays
		.asList(new Object[][] {
			{ 1, "one" },
			{ 21, "twenty one" },
			{ 105, "one hundred and five" },
			{ 1005, "one thousand five" },
			{ 10005, "ten thousand five" },
			{ 22222,
				"twenty two thousand two hundred and twenty two" },
			{ 10005, "ten thousand five" },
			{
				56945780,
				"fifty six million nine hundred and fourty five thousand seven hundred and eighty" },
			{ 999999,
				"nine hundred and ninety nine thousand nine hundred and ninety nine" },

		});
    }

    @Before
    public void before() {
	unit = new DefaultNumberToStringConverterBuilder().build();
    }

    @Test
    public void givenInputNumberShouldReturnStringRepresentation() {
	String actual = unit.findStringEqivalentForNumber(inputInteger);
	Assert.assertEquals(expectedOutputString, actual);
    }
}
