package parsing;

import entities.Component;
import entities.Composite;
import entities.Leaf;
import entities.LeafType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    public static final String PARSING_TEST = "aaaa.\ndddd";
    public static final Leaf FIRST_EXPECTED_WORD = new Leaf("aaaa", LeafType.WORD);
    public static final Leaf SECOND_EXPECTED_WORD = new Leaf("dddd", LeafType.WORD);
    public static final Composite FIRST_SENTENCE = new Composite(Collections.singletonList(FIRST_EXPECTED_WORD));
    public static final Composite SECOND_SENTENCE = new Composite(Collections.singletonList(SECOND_EXPECTED_WORD));
    public static SentenceParser sentenceParser;
    @BeforeClass
    public static void before(){
        sentenceParser =  Mockito.mock(SentenceParser.class);
    }
    @Test
    public void testParse() {
        //given
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        //when
        when(sentenceParser.parse(anyString())).thenReturn(new Composite(
                Arrays.asList(FIRST_EXPECTED_WORD)), new Composite(Arrays.asList(SECOND_EXPECTED_WORD)));
        Composite expected = new Composite(Arrays.asList(FIRST_SENTENCE,SECOND_SENTENCE));
        Composite actual = (Composite) paragraphParser.parse(PARSING_TEST);
        //then
        Assert.assertEquals(actual,expected);
    }
}