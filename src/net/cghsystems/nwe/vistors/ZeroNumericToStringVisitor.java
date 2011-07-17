package net.cghsystems.nwe.vistors;

import net.cghsystems.nwe.ZeroStringRepresentationStrategy;

public class ZeroNumericToStringVisitor implements NumericToStringVisitor {

    private final ZeroStringRepresentationStrategy zeroStringDisplay;

    public ZeroNumericToStringVisitor(ZeroStringRepresentationStrategy zeroStringDisplay) {
	this.zeroStringDisplay = zeroStringDisplay;
    }

    @Override
    public String getNumberAsString(Integer number) {
	return zeroStringDisplay.getStringDisplay();
    }

    @Override
    public boolean isInRange(Integer number) {
	return number == 0;
    }
}
