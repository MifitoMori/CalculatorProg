public class BinarySystem extends NumberSystems{
    private static final int radix = 2;

    public static int compareBinary(String binary1, String binary2) {
        if (binary1.length() > binary2.length()) {
            return 1;
        } else if (binary1.length() < binary2.length()) {
            return -1;
        } else {
            return binary1.compareTo(binary2);
        }
    }

    public String GetValueNumSys(String num, int Sustems){
        return Integer.toString(GetDecimalForm(num, Sustems), radix);
    }
    public boolean isValidNumber(String num){
        return isValidAllNum(num, radix);
    }
    public String opAdd(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0; // Перенос
        int i = binary1.length() - 1;
        int j = binary2.length() - 1;

        // Проходим по битам с конца
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += binary1.charAt(i) - '0'; // Преобразуем символ в число
                i--;
            }
            if (j >= 0) {
                sum += binary2.charAt(j) - '0'; // Преобразуем символ в число
                j--;
            }
            result.append(sum % 2); // Добавляем текущий бит
            carry = sum / 2; // Обновляем перенос
        }
        return result.reverse().toString(); // Переворачиваем результат
    }
    public  String opSubtract(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int borrow = 0; // Заем
        int i = binary1.length() - 1;
        int j = binary2.length() - 1;

        // Проходим по битам с конца
        while (i >= 0 || j >= 0) {
            int bit1 = (i >= 0) ? binary1.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? binary2.charAt(j) - '0' : 0;

            int diff = bit1 - bit2 - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append(diff);
            i--;
            j--;
        }
        // Удаляем ведущие нули
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }

    public String opMultiply(String binary1, String binary2) {
        String result = "0";

        // Проходим по каждому биту второго числа
        for (int j = binary2.length() - 1; j >= 0; j--) {
            if (binary2.charAt(j) == '1') {
                // Сдвигаем первое число на нужное количество позиций
                String temp = binary1;
                for (int k = 0; k < binary2.length() - 1 - j; k++) {
                    temp += "0";
                }
                result = opAdd(result, temp); // Складываем с результатом
            }
        }

        return result;
    }

    public  String opDivide(String binary1, String binary2) {
        if (binary2.equals("0")) {
            throw new ArithmeticException("Деление на ноль");
        }

        String quotient = "0"; // Частное
        String remainder = binary1; // Остаток

        // Пока остаток больше или равен делителю
        while (compareBinary(remainder, binary2) >= 0) {
            remainder = opSubtract(remainder, binary2);
            quotient = opAdd(quotient, "1");
        }

        return quotient;
    }
}
