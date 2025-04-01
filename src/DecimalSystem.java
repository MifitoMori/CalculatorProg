import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalSystem extends NumberSystems{
    private static final int radix = 10;

    public static String GetValueNumSys(String num, int Sustems){
        return Integer.toString(GetDecimalForm(num, Sustems), radix); // Для других систем
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, 1, radix)=="валидный"?true:false;
    }

    // Сложение двух десятичных чисел (вход и выход — строки)
    @Override
    public  String opAdd(String num1, String num2) {
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        return decimal1.add(decimal2).toString();
    }

    // Вычитание двух десятичных чисел (вход и выход — строки)
    public static String opSubtract(String num1, String num2) {
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        return decimal1.subtract(decimal2).toString();
    }

    // Умножение двух десятичных чисел (вход и выход — строки)
    public static String opMultiply(String num1, String num2) {
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        return decimal1.multiply(decimal2).toString();
    }

    // Деление двух десятичных чисел (вход и выход — строки)
    public static String opDivide(String num1, String num2) {
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);

        if (decimal2.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }

        // Динамическое вычисление scale
        int scale = decimal1.scale() + decimal2.scale();
        return decimal1.divide(decimal2, scale, RoundingMode.HALF_UP).toString();
    }
}
