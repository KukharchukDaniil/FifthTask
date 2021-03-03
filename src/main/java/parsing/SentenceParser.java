package parsing;

import entities.Component;
import entities.Composite;
import entities.Leaf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser{
    private static final String DELIMITER = "([\\s,?\\n])+";
    public SentenceParser(Parser successor) {
        super(successor);
    }

    public SentenceParser() {
        super();
    }

    @Override
    protected String getDelimiter() {
        return DELIMITER;
    }

}
