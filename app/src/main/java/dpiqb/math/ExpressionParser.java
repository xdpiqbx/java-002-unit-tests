package dpiqb.math;

import java.util.Arrays;

public class ExpressionParser {
    public Expression parse(String expression) {
        try{
            ParseState state = ParseState.a;

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            Expression.Operator operator = null;

            char[] chars = expression.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (i==0){
                    a.append(c);
                }else{
                    switch (state){
                        case a:
                            if (isOperator(c)){
                                operator = getOperator(c);
                                state = ParseState.b;
                            }else{
                                a.append(c);
                            }
                            break;
                        case b:
                            b.append(c);
                            break;
                    }
                }
            }

            return Expression.builder()
                    .a(Integer.parseInt(a.toString()))
                    .b(Integer.parseInt(b.toString()))
                    .operator(operator)
                    .build();
        }catch (Exception ex){
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
    }

    private enum ParseState{
        a, b
    }

    private boolean isOperator(char c){
        return Arrays.stream(Expression.Operator.values())
                .mapToInt(it -> it.toChar())
                .anyMatch(it -> c == it);
    }

    private Expression.Operator getOperator(char c){
        return Arrays.stream(Expression.Operator.values())
                .filter(it -> it.toChar() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
