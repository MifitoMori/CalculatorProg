import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static String inputNum;
    static int mainSystems;
    static String[] arg;
    static ExpressionValidatorStr proverka = new ExpressionValidatorStr();
    static BinarySystem binarySystem = new BinarySystem();
    static OctalSystem octalSystem = new OctalSystem();
    static DecimalSystem decimalSystem = new DecimalSystem();
    static HexadecimalSystem hexadecimalSystem = new HexadecimalSystem();
    static List<NumberSystems> list = new ArrayList<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void setList(){
        list.add(binarySystem);
        list.add(octalSystem);
        list.add(decimalSystem);
        list.add(hexadecimalSystem);
    }
    public static void main(String[] args) throws IOException {
        setList();
        inputNum = reader.readLine();
        arg = proverka.parseExpression(inputNum);
        if (arg != null) {
            System.out.printf("[%s, %s, %s]%n", arg[0], arg[1], arg[2]);
        } else {
            System.out.println("Invalid expression");
        }
        String res = binarySystem.operationsOnNumbers(arg);
        System.out.println(res);
        reader.close();
    }
}