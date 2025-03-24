public class OctalSystem extends NumberSystems{
    private static final int radix = 8;

    public String GetValueNumSys(String num, int Sustems){
        return Integer.toOctalString(GetDecimalForm(num, Sustems));
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

