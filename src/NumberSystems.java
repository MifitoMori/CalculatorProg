abstract class NumberSystems { //Система счисления

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

    abstract String GetValueNumSys(String num, int Systems);
    abstract boolean isValidNumber(String num);
    abstract String opAdd(String numA,String numB );
    abstract String opSubtract(String numA,String numB );
    abstract String opMultiply(String numA,String numB );
    abstract String opDivide(String numA,String numB );

}
