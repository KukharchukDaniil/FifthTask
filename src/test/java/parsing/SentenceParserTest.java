package parsing;

import entities.Composite;
import entities.Leaf;
import entities.LeafType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SentenceParserTest {
    public static final String TEXT = "aaaa, dddd, [2 3 +]";
    public static final Leaf FIRST_EXPECTED_WORD = new Leaf("aaaa", LeafType.WORD);
    public static final Leaf SECOND_EXPECTED_WORD = new Leaf("dddd",LeafType.WORD);
    public static final Leaf EXPRESSION_WORD = new Leaf("[2 4 +]", LeafType.EXPRESSION);
    @Test
    public void testParse() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);
        Composite expected = new Composite(Arrays.asList(FIRST_EXPECTED_WORD,SECOND_EXPECTED_WORD,EXPRESSION_WORD));
        //when
        Composite actual = (Composite) sentenceParser.parse(TEXT);
        //then
        Assert.assertEquals(actual,expected);
    }
}