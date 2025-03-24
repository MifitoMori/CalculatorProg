public class HexadecimalSystem extends NumberSystems{
    private static final int radix = 16;

    public String GetValueNumSys(String num, int Sustems){ // такая схема позваляет для каждой системы счисления писать минимум, чтобы можно было получить нужный результат
        return Integer.toHexString(GetDecimalForm(num, Sustems));
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }

    public String opAdd(String binary1, String binary2) {
        return GetValueNumSys(opAddAll(binary1, binary2, radix), 10);
    }

    public  String opSubtract(String minuend, String subtrahend) {
        // Возвращаем результат в бинарном виде
        return GetValueNumSys(opSubtractAll(minuend, subtrahend, radix), 10);
    }

    public String opMultiply(String binary1, String binary2) {
        return GetValueNumSys(opMultiplyAll(binary1, binary2, radix), 10);
    }

    public String opDivide(String binary1, String binary2) {
        return GetValueNumSys(opDivideAll(binary1, binary2, radix), 10);
    }
}
