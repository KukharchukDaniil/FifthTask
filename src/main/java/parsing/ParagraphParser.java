package parsing;

import entities.Component;
import entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends AbstractParser {

    public static final String DELIMITER = "[.|!|?]";
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getDelimiter() {
        return DELIMITER;
    }
}
