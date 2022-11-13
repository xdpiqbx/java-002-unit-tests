package dpiqb.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {
    private ExpressionParser parser;

    @BeforeEach
    public void beforeEach(){
        parser = new ExpressionParser();
    }
    private void test(String expression, int expectedA, int expectedB, Expression.Operator expectedOperator) {
        Expression actual = parser.parse(expression);

        Expression expected = Expression
                .builder()
                .a(expectedA)
                .b(expectedB)
                .operator(expectedOperator)
                .build();

        Assertions.assertEquals(expected, actual);
    }

    // "3+5" - a=3 b=5 operator=+
    @Test
    public void test3plus5(){
        test("3+5", 3, 5, Expression.Operator.plus);
    }
    // "-2-4" - a=-2 b=4 operator=-
    @Test
    public void testMinus2minus4(){
        test("-2-4", -2, 4, Expression.Operator.minus);
    }
    // "4*-5" - a=4 b=-5 operator=*
    @Test
    public void test4MultiplyMinus5(){
        test("4*-5", 4, -5, Expression.Operator.multiply);
    }
    // "-6/-4" - a=-6 b=-4 operator=/
    @Test
    public void testMinus6DivideMinus4(){
        test("-6/-4", -6, -4, Expression.Operator.divide);
    }
    // "-5--4" - a=-5 b=-4 operator=-
    @Test
    public void testMinus5MinusMinus4(){
        test("-5--4", -5, -4, Expression.Operator.minus);
    }
    @Test
    public void testThatWhiteSpacesIgnored(){
        test("   5 - 3 \t\n", 5, 3, Expression.Operator.minus);
    }
    // IllegalArgumentException - 5, 5+, 6++3, 8-aaa, 5.3+7
    @Test
    public void testThatInvalidInputCorrectlyHandled(){
        String[] invalidInputs = {
                null, "", " ", "3", "3 6", "-", "3+hhh", "7---6"
        };
        for (String invalidInput : invalidInputs) {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    ()-> parser.parse(invalidInput),
                    invalidInput
            );
        }
    }
}