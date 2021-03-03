package parsing;

import entities.Composite;
import entities.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SentenceParserTest {
    public static final String TEXT = "aaaa, dddd";
    public static final Leaf FIRST_EXPECTED_WORD = new Leaf("aaaa");
    public static final Leaf SECOND_EXPECTED_WORD = new Leaf("dddd");
    @Test
    public void parse() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);
        Composite expected = new Composite(Arrays.asList(FIRST_EXPECTED_WORD,SECOND_EXPECTED_WORD));
        //when
        Composite actual = (Composite) sentenceParser.parse(TEXT);
        //then
        Assert.assertEquals(actual,expected);
    }
}