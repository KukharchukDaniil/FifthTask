package parsing;

import entities.Composite;
import entities.Leaf;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class TextParserTest {
    public static final String PARSING_TEST = "aaaa.\ndddd\tbbbb";
    public static final Leaf FIRST_WORD = new Leaf("aaaa");
    public static final Leaf SECOND_WORD = new Leaf("dddd");
    public static final Leaf THIRD_WORD = new Leaf("bbb");
    public static final Composite FIRST_SENTENCE = new Composite(Collections.singletonList(FIRST_WORD));
    public static final Composite SECOND_SENTENCE = new Composite(Collections.singletonList(SECOND_WORD));
    public static final Composite THIRD_SENTENCE = new Composite(Collections.singletonList(THIRD_WORD));
    public static final Composite FIRST_PARAGRAPH = new Composite(Arrays.asList(FIRST_SENTENCE,SECOND_SENTENCE));
    public static final Composite SECOND_PARAGRAPH = new Composite(Arrays.asList(THIRD_SENTENCE));
    public static SentenceParser sentenceParser;
    public static ParagraphParser paragraphParser;
    @BeforeClass
    public static void before(){
        sentenceParser = Mockito.mock(SentenceParser.class);
        paragraphParser = Mockito.mock(ParagraphParser.class);
    }
    @Test
    public void parse() {
        //given
        TextParser textParser = new TextParser( new ParagraphParser(new SentenceParser(null)));
        Composite expected = new Composite(Arrays.asList(FIRST_PARAGRAPH,SECOND_PARAGRAPH));
        //when
        when(paragraphParser.parse(anyString())).thenReturn(new Composite(Arrays.asList(
                FIRST_SENTENCE,SECOND_SENTENCE
        )),new Composite(Arrays.asList(THIRD_SENTENCE)));
        Composite actual = (Composite) textParser.parse(PARSING_TEST);
        //then
        Assert.assertEquals(expected,actual);
    }
}