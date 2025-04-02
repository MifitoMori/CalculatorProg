public class BinarySystem extends NumberSystems{
    private static final int radix = 2;
    @Override
    public String GetValueNumSys(String num, int Sustems){
        return Integer.toBinaryString(GetDecimalForm(num, Sustems));
    }
    public static String isValidNumber(String num1, String num2) {//Перегрузка метода для более удобного использования, а так проверка осуществялется в методе с одной переменной
        return isValidAllNum(num1, 1, radix) == "валидный"  && isValidAllNum(num2, 2, radix) == "валидный" ? "валидный" :isValidAllNum(num1, 1, radix) + isValidAllNum(num2, 2, radix);
    }
    public boolean isValidSystem(int num){
        return num==radix?true:false;
    }
    @Override
    protected String opAdd(String nam1, String nam2) {
        return isValidNumber(nam1, nam2) == "валидный"? GetValueNumSys(opAddAll(nam1, nam2, radix), 10): isValidNumber(nam1, nam2);
    }
    @Override
    protected String opSubtract(String num1, String num2) {
        // Возвращаем результат в бинарном виде
        return isValidNumber(num1, num2) == "валидный"? GetValueNumSys(opSubtractAll(num1, num2, radix), 10): isValidNumber(num1, num2);
    }
    @Override
    protected String opMultiply(String nam1, String num2) {
        return isValidNumber(nam1, num2) == "валидный"? GetValueNumSys(opMultiplyAll(nam1, num2, radix), 10): isValidNumber(nam1, num2);
    }
    @Override
    protected String opDivide(String num1, String num2) {
        try {
            return isValidNumber(num1, num2) == "валидный"? GetValueNumSys(opDivideAll(num1, num2, radix), 10): isValidNumber(num1, num2);
        } catch (Exception e) {
            return opDivideAll(num1, num2, radix);
        }
    }
}
