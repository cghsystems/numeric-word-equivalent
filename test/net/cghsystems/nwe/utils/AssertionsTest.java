package net.cghsystems.nwe.utils;

import net.cghsystems.nwe.utils.Assertions;

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
