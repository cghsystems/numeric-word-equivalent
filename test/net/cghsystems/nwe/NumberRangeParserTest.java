package net.cghsystems.nwe;

import static junit.framework.Assert.assertEquals;
import junit.framework.Assert;

import net.cghsystems.nwe.NumberRangeParser;
import net.cghsystems.nwe.NumberRangeParser.NumberRange;

import org.junit.Before;
import org.junit.Test;


public class NumberRangeParserTest {

    private static NumberRangeParser unit;

    public static final class HundredRangeNumberTests {

	@Before
	public void before() {
	    unit = new NumberRangeParser(NumberRange.HUNDRED);
	}

	@Test
	public void givenANumberWithAValidHundredRangeOf777ThenShouldReturnParsedNumberOf777() {
	    Integer thousand = 999888777;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(777, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredRangeOf077ThenShouldReturnParsedNumberOf77() {
	    Integer thousand = 999888077;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(77, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredRangeOf007ThenShouldReturnParsedNumberOf7() {
	    Integer thousand = 999888007;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(7, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredRangeOf0ThenShouldReturnParsedNumberOf0() {
	    Integer thousand = 999888000;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(000, actual.intValue());
	}
    }

    public static final class HundredThousandRangeNumberTests {
	@Before
	public void before() {
	    unit = new NumberRangeParser(NumberRange.HUNDRED_THOUSAND);
	}

	@Test
	public void givenANumberWithAValidHundredThousandRangeOf888ThenShouldReturnParsedNumberOf888() {
	    Integer thousand = 999888777;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(888, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredThousandRangeOf088ThenShouldReturnParsedNumberOf88() {
	    Integer thousand = 999088777;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(88, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredThousandRangeOf008ThenShouldReturnParsedNumberOf8() {
	    Integer thousand = 999008777;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(8, actual.intValue());
	}

	@Test
	public void givenANumberWithAValidHundredThousandRangeOf0ThenShouldReturnParsedNumberOf0() {
	    Integer thousand = 999000777;
	    Integer actual = unit.getRangeNumber(thousand);
	    assertEquals(000, actual.intValue());
	}

	@Test
	public void shouldReturnCorectdescription() {
	    assertEquals("thousand", unit.getRangeDescription());
	}
    }

    public static final class MillionRangeNumberTests {

	@Before
	public void before() {
	    unit = new NumberRangeParser(NumberRange.MILLION);
	}

	@Test
	public void givenAValidMillionNumber999999999ShouldReturnTheParsedMillionNumberOf999() {
	    Integer million = 999999999;
	    Integer actual = unit.getRangeNumber(million);
	    assertEquals(999, actual.intValue());
	}

	@Test
	public void givenAValidMillionNumberOf99999999ShouldReturnTheParsedMillionNumberOf99() {
	    Integer million = 99999999;
	    Integer actual = unit.getRangeNumber(million);
	    Assert.assertEquals(99, actual.intValue());
	}

	@Test
	public void givenAValidMillionNumberOf9999999ShouldReturnTheParsedMillionNumberOf9() {
	    Integer million = 9999999;
	    Integer actual = unit.getRangeNumber(million);
	    Assert.assertEquals(9, actual.intValue());
	}

	@Test
	public void givenAnInValidMillionNumberOf999999ShouldReturnTheParsedMillionNumberOf0() {
	    Integer million = 999999;
	    Integer actual = unit.getRangeNumber(million);
	    Assert.assertEquals(0, actual.intValue());
	}

	@Test
	public void shouldReturnCorectdescription() {
	    assertEquals("million", unit.getRangeDescription());
	}

    }

    public static class ThousandNumberTests {

	@Before
	public void before() {
	    unit = new NumberRangeParser(NumberRange.HUNDRED_THOUSAND);
	}

	@Test
	public void shouldFindBug() {
	    Integer rangeNumber = unit.getRangeNumber(1005);
	    assertEquals(1, rangeNumber.intValue());
	}

    }
}
