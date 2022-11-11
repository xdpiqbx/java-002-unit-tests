package dpiqb.math;

public class ExpressionParser {
    public Expression parse(String expression) {
        String[] parts = expression.split("\\+");
        return Expression.builder()
                .a(Integer.parseInt(parts[0]))
                .b(Integer.parseInt(parts[1]))
                .operator(Expression.Operator.plus)
                .build();
    }
}
