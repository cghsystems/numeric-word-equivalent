package com.emergn.chedley.vistors;

public interface NumericToStringVisitor {

    String getNumberAsString(Integer number);

    boolean isInRange(Integer number);

}
