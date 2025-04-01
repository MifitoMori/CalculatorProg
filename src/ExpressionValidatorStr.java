import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressionValidatorStr {
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(
            "^\\s*([A-Z0-9]+)\\s*([+\\-*/])\\s*([A-Z0-9]+)\\s*$"
    );

    // Паттерн для проверки допустимых символов в числах (можно модифицировать под системы счисления)
    private static final Pattern VALID_CHARS_PATTERN = Pattern.compile(
            "^[A-Z0-9]+$"
    );

    public static String[] parseExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return null;
        }

        Matcher matcher = EXPRESSION_PATTERN.matcher(expression);
        if (!matcher.matches()) {
            return null;
        }

        String leftOperand = matcher.group(1);
        String operator = matcher.group(2);
        String rightOperand = matcher.group(3);

        if (!VALID_CHARS_PATTERN.matcher(leftOperand).matches() ||
                !VALID_CHARS_PATTERN.matcher(rightOperand).matches()) {
            return null;
        }

        if (countOperators(expression) != 1) {
            return null;
        }

        return new String[]{leftOperand, operator, rightOperand};
    }

    private static int countOperators(String expression) {
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                count++;
            }
        }
        return count;
    }
}
