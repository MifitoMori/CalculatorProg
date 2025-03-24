import java.math.BigInteger;

public class BinarySystem extends NumberSystems{
    private static final int radix = 2;
    private static String isValidBinaryString(String binaryString, int num) {
        // 1. Проверка на null
        if (binaryString == null) {
            return String.format("Аргумент %s имеет значение NULL", num);
        }
        // 2. Проверка на пустую строку
        if (binaryString.isEmpty()) {
            return String.format("Аргумент %s имеет пустое значение", num);
        }
        // 3. Проверка на допустимые символы (только 0 и 1)
        if (!binaryString.matches("[01]+")) {
            return String.format("У аргумента %s другая система счисления", num);
        }
        // 4. Проверка на максимальную длину (чтобы избежать переполнения памяти)
        if (binaryString.length() > 1000000) { // Ограничение в 1 млн символов
            return String.format("У аргумента %s превышено количество символов", num);
        }
        return "валидный";
    }
    public static String areValidBinaryStrings(String binaryStr1, String binaryStr2) {
        return isValidBinaryString(binaryStr1, 1) == "валидный"  && isValidBinaryString(binaryStr2, 2) == "валидный" ? "валидный" :isValidBinaryString(binaryStr1, 1) + isValidBinaryString(binaryStr2, 2);
    }
    public String GetValueNumSys(String num, int Sustems){
        return Integer.toBinaryString(GetDecimalForm(num, Sustems));
    }

    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }

    public String opAdd(String binary1, String binary2) {
        return areValidBinaryStrings(binary1, binary2) == "валидный"? GetValueNumSys(opAddAll(binary1, binary2, radix), 10): areValidBinaryStrings(binary1, binary2);
    }

    public  String opSubtract(String minuend, String subtrahend) {
        // Возвращаем результат в бинарном виде
        return areValidBinaryStrings(minuend, subtrahend) == "валидный"? GetValueNumSys(opSubtractAll(minuend, subtrahend, radix), 10): areValidBinaryStrings(minuend, subtrahend);
    }

    public String opMultiply(String binary1, String binary2) {
        return areValidBinaryStrings(binary1, binary2) == "валидный"? GetValueNumSys(opMultiplyAll(binary1, binary2, radix), 10): areValidBinaryStrings(binary1, binary2);
    }

    public String opDivide(String binary1, String binary2) {
        if(opDivideAll(binary1, binary2, radix) == "0"){//здесь нужно проверить код на ошибки

        }
        return areValidBinaryStrings(binary1, binary2) == "валидный"? GetValueNumSys(opDivideAll(binary1, binary2, radix), 10): areValidBinaryStrings(binary1, binary2);
    }
}
