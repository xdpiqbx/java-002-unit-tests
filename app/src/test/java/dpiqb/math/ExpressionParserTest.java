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
    // "3+5" - a=3 b=5 operator=+

    @Test
    public void test3plus5(){
        Expression actual = parser.parse("3+5");

        Expression expected = Expression
                .builder()
                .a(3)
                .b(5)
                .operator(Expression.Operator.plus)
                .build();

        Assertions.assertEquals(expected, actual);
    }

    // "-2-4" - a=-2 b=4 operator=-
    // "4*-5" - a=4 b=-5 operator=*
    // "-6/-4" - a=-6 b=-4 operator=/
    // "-5--4" - a=-5 b=-4 operator=-

    // IllegalArgumentException - 5, 5+, 6++3, 8-aaa, 5.3+7
}