package net.cghsystems.nwe.vistors;

public interface NumericToStringVisitor {

    String getNumberAsString(Integer number);

    boolean isInRange(Integer number);

}
