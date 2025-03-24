import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

abstract class NumberSystems { //Система счисления

    abstract String GetValueNumSys(String num, int Systems);//преобразование числа в свою систему счисления
    abstract boolean isValidNumber(String num);//проверка значений
    abstract String opAdd(String numA,String numB );
    abstract String opSubtract(String numA,String numB );
    abstract String opMultiply(String numA,String numB );
    abstract String opDivide(String numA,String numB );

    protected static int GetDecimalForm(String num, int radix)
    {
        try {
            return Integer.parseInt(num, radix);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное число для указанной системы счисления");
        }
    }
    protected static boolean isValidAllNum(String num, int radix)
    {
        String validCharacters;
        if (radix <= 10) {
            // Для систем счисления от 2 до 10 допустимы только цифры от 0 до (radix - 1)
            validCharacters = "[0-" + (radix - 1) + "]+";
        } else {
            // Для систем счисления больше 10 допустимы цифры и буквы от A до (radix - 11 + 'A')
            validCharacters = "[0-9A-" + (char) ('A' + (radix - 11)) + "]+";
        }

        // Проверяем, соответствует ли число допустимым символам
        return num.matches(validCharacters);
    }

    protected static String opAddAll(String num1, String num2, int radix) {
        BigInteger decimal1 = new BigInteger(num1, radix);
        BigInteger decimal2 = new BigInteger(num2, radix);
        return decimal1.add(decimal2).toString();
    }

    // Вычитание двух десятичных чисел (вход и выход — строки)
    protected static String opSubtractAll(String num1, String num2, int radix) {
        BigInteger decimal1 = new BigInteger(num1, radix);
        BigInteger decimal2 = new BigInteger(num2, radix);
        return decimal1.subtract(decimal2).toString();
    }

    // Умножение двух десятичных чисел (вход и выход — строки)
    protected static String opMultiplyAll(String num1, String num2, int radix) {
        BigInteger decimal1 = new BigInteger(num1, radix);
        BigInteger decimal2 = new BigInteger(num2, radix);
        return decimal1.multiply(decimal2).toString();
    }

    // Деление двух десятичных чисел (вход и выход — строки)
    protected static String opDivideAll(String num1, String num2, int radix) {
        BigInteger decimal1 = new BigInteger(num1, radix);
        BigInteger decimal2 = new BigInteger(num2, radix);
        return decimal1.toString() == "0" || decimal2.toString() == "0"? "Деление на 0 не допустимо": decimal1.divide(decimal2).toString();
    }

}
