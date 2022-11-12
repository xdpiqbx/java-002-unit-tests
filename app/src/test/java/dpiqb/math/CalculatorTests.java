package dpiqb.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {
    private Calculator calculator;
    @BeforeEach
    public void beforeEach(){
        calculator = new Calculator();
    }

    @Test
    public void testThatExpressionCalculatedCorrectly(){
        Expression expression = Expression.builder()
                .a(3)
                .b(4)
                .operator(Expression.Operator.plus)
                .build();

        Assertions.assertEquals(7, calculator.calculate(expression));
    }
}