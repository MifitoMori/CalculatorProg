import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static String result;
    static String inputNum;
    static int mainSystems = 10;
    static String[] arg;
    static ExpressionValidatorStr proverka = new ExpressionValidatorStr();
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
    static void resSystems(String num){
        if(num == null){
            System.out.println("Данная система счисления отсутствует, добавьте ее в библиотеку, либо выберете ту, которая есть ");
            mainSystems = 10;
            return;
        }
        for(NumberSystems system : list){
            System.out.println(system.toString() + ": " + system.GetValueNumSys(num, mainSystems));
        }
    }static String calculationRes(){
        if(arg == null)
            System.out.println("Введена неправильно операция!!!");
        for(NumberSystems system : list){
            if(system.isValidSystem(mainSystems)){
                return system.operationsOnNumbers(arg);
            }
        }
        return null;

    }
    static String nameSystems(){
        for(NumberSystems system : list){
            if(system.isValidSystem(mainSystems)){
                return system.toString();
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        setList();

        while (true){
            try{
                System.out.println();
                System.out.printf("На данный момент система счисления: %s", nameSystems());
                System.out.println();
                System.out.println("Введите систему счисления цифрой, либо введите 0, если хотите остаться на прежней: ");
                Scanner readerInt = new Scanner(System.in);
                int checking = readerInt.nextInt();
                mainSystems = checking == 0?mainSystems:checking;
                System.out.println("Введите операцию, которую хотите вычислить: ");
                Scanner readerStr = new Scanner(System.in);
                inputNum = readerStr.nextLine();
                arg = proverka.parseExpression(inputNum);
                if (arg != null) {
                    System.out.printf("[%s, %s, %s]%n", arg[0], arg[1], arg[2]);
                }
                result = calculationRes();
                resSystems(result);
            } catch (Exception e) {
                System.out.println("Произошла ошибка(");
            }
        }



    }
}