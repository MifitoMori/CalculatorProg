public class DecimalSystem extends NumberSystems{
    private static final int radix = 10;

    public String GetValueNumSys(String num, int Sustems){
        return Integer.toString(GetDecimalForm(num, Sustems), radix); // Для других систем
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }
}
