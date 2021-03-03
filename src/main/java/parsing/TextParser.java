package parsing;

import entities.Component;
import entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser extends AbstractParser {
    private final static String DELIMITER = "[\\t\\r]";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getDelimiter() {
        return DELIMITER;
    }

}
