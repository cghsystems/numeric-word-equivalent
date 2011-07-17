package com.emergn.chedley.ioc;

import com.emergn.chedley.DefaultNumberToStringConverter;
import com.emergn.chedley.NumberToStringConverter;

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
