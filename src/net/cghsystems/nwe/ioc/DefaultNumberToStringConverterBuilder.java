package net.cghsystems.nwe.ioc;

import net.cghsystems.nwe.DefaultNumberToStringConverter;
import net.cghsystems.nwe.NumberToStringConverter;

public class DefaultNumberToStringConverterBuilder implements
	Builder<DefaultNumberToStringConverter> {

    @Override
    public DefaultNumberToStringConverter build() {

	NumberToStringConverter millionParser = ClassIntances.MILLION_RANGE_PARSER;
	NumberToStringConverter hundredThousandParser = ClassIntances.HUNDRED_THOUSAND_RANGE_PARSER;
	NumberToStringConverter hundredParser = ClassIntances.HUNDRED_RANGE_PARSER;

	return new DefaultNumberToStringConverter(millionParser,
		hundredThousandParser, hundredParser);
    }
}
