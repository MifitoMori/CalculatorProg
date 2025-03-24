public class OctalSystem extends NumberSystems{
    private static final int radix = 8;

    public String GetValueNumSys(String num, int Sustems){
        return Integer.toString(GetDecimalForm(num, Sustems), radix);
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }
    public String opAdd(String octal1, String octal2) {
        return "ad";
    }
    // Вычитание двух восьмеричных чисел
    public String opSubtract(String octal1, String octal2) {
        return "asd";
    }
    // Умножение двух восьмеричных чисел
    public String opMultiply(String octal1, String octal2) {
        return "asdf";
    }

    // Деление двух восьмеричных чисел
    public  String opDivide(String octal1, String octal2) {
        return "decimalToOctal(result)";
    }
}

