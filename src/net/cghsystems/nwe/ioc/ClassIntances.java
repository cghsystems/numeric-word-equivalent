package net.cghsystems.nwe.ioc;

import net.cghsystems.nwe.DefaultNumberToStringConverter;
import net.cghsystems.nwe.LessThan1000NumericToStringConverter;
import net.cghsystems.nwe.NumberRangeNumberToStringConverter;
import net.cghsystems.nwe.NumberRangeParser;
import net.cghsystems.nwe.NumberToStringConverter;

//In prod would usually use IoC container technology such as spring or guice to handle for this for me.
public class ClassIntances {

    public static final LessThan1000NumericToStringConverter LESS_THAN1000_NUMERIC_TO_STRING_CONVERTER = new LessThan1000NumericToStringConverterBuilder()
	    .build();

    public static final NumberToStringConverter MILLION_RANGE_PARSER = new NumberRangeNumberToStringConverter(
	    NumberRangeParser.MILLION_RANGE_PARSER,
	    LESS_THAN1000_NUMERIC_TO_STRING_CONVERTER);

    public static final NumberToStringConverter HUNDRED_THOUSAND_RANGE_PARSER = new NumberRangeNumberToStringConverter(
	    NumberRangeParser.HUNDRED_THOUSAND_RANGE_PARSER,
	    LESS_THAN1000_NUMERIC_TO_STRING_CONVERTER);
    public static final NumberToStringConverter HUNDRED_RANGE_PARSER = new NumberRangeNumberToStringConverter(
	    NumberRangeParser.HUNDRED_RANGE_PARSER,
	    LESS_THAN1000_NUMERIC_TO_STRING_CONVERTER);

    public static final DefaultNumberToStringConverter DEFAUL_NUMBER_TO_STRING_CONVERTER = new DefaultNumberToStringConverterBuilder()
	    .build();

}
