package com.emergn.chedley.utils;

public class Assertions {

	public static void assertNotNull(Object parameter) {
		if (parameter == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
	}
}
