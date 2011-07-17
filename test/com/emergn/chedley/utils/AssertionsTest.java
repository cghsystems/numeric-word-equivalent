package com.emergn.chedley.utils;

import org.junit.Test;


public class AssertionsTest {

	@Test(expected = IllegalArgumentException.class)
	public void giveANullParameterAssertNotNullShouldReturnIllegalArgumentException() {
		Assertions.assertNotNull(null);
	}

	@Test
	public void giveANonNullParameterAssertNotNullShouldReturnWithoutException() {
		Assertions.assertNotNull("");
	}

}
