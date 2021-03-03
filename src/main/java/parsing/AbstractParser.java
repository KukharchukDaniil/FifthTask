package parsing;

import entities.Component;
import entities.Composite;
import entities.Leaf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractParser implements Parser {
    private Parser successor;
    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public AbstractParser() {

    }
    protected abstract String getDelimiter();
    protected Parser getSuccessor(){
        return successor;
    }

    @Override
    public Component parse(String text) {
        String delimiter = getDelimiter();
        List<String> parsedComponents = Arrays.asList(text.split(delimiter));
        Parser successor = getSuccessor();
        List<Component> components = null;
        if(successor!=null) {
            components = parsedComponents.stream().map(successor::parse).collect(Collectors.toList());
        }else if(this.getClass() == SentenceParser.class){
            components = parsedComponents.stream().map(Leaf::new).collect(Collectors.toList());
        }
        return new Composite(components);
    }
}
