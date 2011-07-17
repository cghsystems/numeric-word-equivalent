package net.cghsystems.nwe;

import java.util.ArrayList;
import java.util.List;

public class DefaultNumberToStringConverter implements NumberToStringConverter {

    private final List<NumberToStringConverter> parsers = new ArrayList<NumberToStringConverter>();

    public DefaultNumberToStringConverter(
	    NumberToStringConverter millionParser,
	    NumberToStringConverter hundredThousandParser,
	    NumberToStringConverter hundredParser) {

	parsers.add(millionParser);
	parsers.add(hundredThousandParser);
	parsers.add(hundredParser);
    }

    @Override
    public String findStringEqivalentForNumber(Integer number) {
	List<String> results = new ArrayList<String>();
	for (NumberToStringConverter parser : parsers) {
	    String res = parser.findStringEqivalentForNumber(number);
	    if (isNotZero(res)) {
		results.add(res.trim());
	    }
	}
	return buildResultString(results);
    }

    private boolean isNotZero(String res) {
	return !res.equals(ZeroStringRepresentationStrategy.DISPLAY_ZERO
		.getStringDisplay());
    }

    private String buildResultString(List<String> results) {
	StringBuilder builder = new StringBuilder();
	for (String string : results) {
	    builder.append(string);
	    builder.append(" ");
	}
	return builder.toString().trim();
    }
}
