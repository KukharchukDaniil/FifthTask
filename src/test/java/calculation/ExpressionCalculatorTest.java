package calculation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculatorTest {
    public static final String EXPRESSION = "[ 8 4 4 + / ]";
    public static final Integer EXPECTED_VALUE = 1;
    @Test
    public void testCalculate() {
        //given
        ExpressionCalculator expressionCalculator = new ExpressionCalculator(EXPRESSION);
        Integer expected = EXPECTED_VALUE;
        //when
        Integer actual = (Integer) expressionCalculator.calculate();
        //then
        Assert.assertEquals(expected,actual);
    }
}