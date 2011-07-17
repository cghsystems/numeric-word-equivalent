package com.emergn.chedley.vistors;

import static com.emergn.chedley.NumberToStringMappingConstants.basicNumberMapping;

import com.emergn.chedley.utils.Assertions;


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
