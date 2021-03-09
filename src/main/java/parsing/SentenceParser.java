package parsing;

import entities.Component;
import entities.Composite;
import entities.Leaf;
import entities.LeafType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser{
    private static final Logger LOGGER = Logger.getLogger(SentenceParser.class);
    private static final String DELIMITER = "(\\w+)|(\\[(([\\d]+[\\s]+)+([\\*\\-\\+\\/])+)\\])";
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

    @Override
    public Component parse(String text) {
        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(text);
        List<String> wordsList = new ArrayList<>();
        while(matcher.find()){
            wordsList.add(matcher.group());
        }
        List<Component> components = new ArrayList<>();
        wordsList.forEach(string->{
            if(string.charAt(0)!='['){
                components.add(new Leaf(string, LeafType.WORD));
            }else{
                components.add(new Leaf(string, LeafType.EXPRESSION));
                LOGGER.info("Expression has been detected: " + string);
            }
        });
        return new Composite(components);
    }
}
