package com.emergn.chedley;

import static com.emergn.chedley.NumberToStringMappingConstants.ZERO;

public enum ZeroStringRepresentationStrategy {
    DISPLAY_ZERO(ZERO), DO_NOT_DISPLAY_ZERO("");

    private final String representation;

    private ZeroStringRepresentationStrategy(String representation) {
	this.representation = representation;
    }

    public String getStringDisplay() {
	return representation;
    }
}