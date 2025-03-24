public class HexadecimalSystem extends NumberSystems{
    private static final int radix = 16;

    public String GetValueNumSys(String num, int Sustems){ // такая схема позваляет для каждой системы счисления писать минимум, чтобы можно было получить нужный результат
        return Integer.toString(GetDecimalForm(num, Sustems), radix);
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }
}
