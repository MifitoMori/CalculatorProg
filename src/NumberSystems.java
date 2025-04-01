import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

abstract class NumberSystems { //Система счисления

    static String GetValueNumSys(String num, int Systems){
        return null;
    };//преобразование числа в свою систему счисления
    abstract boolean isValidNumber(String num);//проверка значений

    String opAdd(String numA, String numB) {
        return null;
    }

    static String opSubtract(String numA,String numB ) {
        return null;
    }
    static String opMultiply(String numA,String numB ) {
        return null;
    }
    static String opDivide(String numA,String numB ) {
        return null;
    }

    protected static int GetDecimalForm(String num, int radix)
    {
        try {
            return Integer.parseInt(num, radix);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное число для указанной системы счисления");
        }
    }
    protected static String isValidAllNum(String num,int seq,  int radix)
    {
        String validCharacters;
        // 1. Проверка на null
        if (num == null) {
            return String.format("Аргумент %s имеет значение NULL. ", seq);
        }
        // 2. Проверка на пустую строку
        if (num.isEmpty()) {
            return String.format("Аргумент %s имеет пустое значение. ", seq);
        }
        // 4. Проверка на максимальную длину (чтобы избежать переполнения памяти)
        if (num.length() > 1000000) { // Ограничение в 1 млн символов
            return String.format("У аргумента %s превышено количество символов. ", seq);
        }
        if (radix <= 10) {
            // Для систем счисления от 2 до 10 допустимы только цифры от 0 до (radix - 1)
            validCharacters = "[0-" + (radix - 1) + "]+";
        } else {
            // Для систем счисления больше 10 допустимы цифры и буквы от A до (radix - 11 + 'A')
            validCharacters = "[0-9A-" + (char) ('A' + (radix - 11)) + "]+";
        }

        // Проверяем, соответствует ли число допустимым символам
        return num.matches(validCharacters)? "валидный":String.format("Аргумент %s не соответствует допустимым значениям. ", seq);
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

    public String operationsOnNumbers(String[] arg){
        if (arg == null)
            return "Invalid expression";
        switch (arg[1]){
            case "+": return opAdd(arg[0], arg[2]);
        }
        return "0";
    }
}
