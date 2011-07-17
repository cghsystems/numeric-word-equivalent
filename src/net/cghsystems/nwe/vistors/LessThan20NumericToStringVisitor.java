package net.cghsystems.nwe.vistors;

import static net.cghsystems.nwe.NumberToStringMappingConstants.basicNumberMapping;
import net.cghsystems.nwe.utils.Assertions;



public class LessThan20NumericToStringVisitor implements NumericToStringVisitor {

    @Override
    public String getNumberAsString(Integer number) {
	String basicNumber = basicNumberMapping.get(number);
	Assertions.assertNotNull(basicNumber);
	return basicNumber;
    }

    @Override
    public boolean isInRange(Integer number) {
	return number < 20;
    }
}
