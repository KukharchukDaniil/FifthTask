package calculation.operation;

import calculation.AbstractMathExpression;
import calculation.Context;

public class TerminalExpressionMinus extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() - c.popValue());
    }
}
