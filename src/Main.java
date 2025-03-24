import java.util.ArrayList;
import java.util.List;

public class Main {
    static String inputNum;
    static NumberSystems mainSystems;
    static BinarySystem binarySystem = new BinarySystem();
    static OctalSystem octalSystem = new OctalSystem();
    static DecimalSystem decimalSystem = new DecimalSystem();
    static HexadecimalSystem hexadecimalSystem = new HexadecimalSystem();
    static List<NumberSystems> list = new ArrayList<>();

    static void setList(){
        list.add(binarySystem);
        list.add(octalSystem);
        list.add(decimalSystem);
        list.add(hexadecimalSystem);
    }
    public static void main(String[] args) {
        setList();

    }
}