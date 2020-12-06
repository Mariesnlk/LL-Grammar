
import java.util.List;

public class MainRPN {

    public static void main(String[] args) {
        RPNCalculator calculator = new RPNCalculator();

        String str1 = "A=(B*6^7-C+7)^V^4^4";
        List<String> expr1 = RPNCalculator.splitLine(str1);
        List<String> res1 = calculator.convertToRPN(expr1);
        System.out.println("Input: " + str1);
        System.out.println("Res: " + calculator.listToString(res1));
        System.out.println();

        String str2 = "A=2+M[1,j,j+3]^5";
        List<String> expr2 = RPNCalculator.splitLine(str2);
        List<String> res2 = calculator.convertToRPN(expr2);
        System.out.println("Input: " + str2);
        System.out.println("Res: " + calculator.listToString(res2));
        System.out.println();

        String str3 = "A=2+f(2x)";
        List<String> expr3 = RPNCalculator.splitLine(str3);
        List<String> res3 = calculator.convertToRPN(expr3);
        System.out.println("Input: " + str3);
        System.out.println("Res: " + calculator.listToString(res3));
        System.out.println();

        String str4 = "sin(15+30)+sin(15+30)";
        List<String> expr4 = RPNCalculator.splitLine(str4);
        List<String> res4 = calculator.convertToRPN(expr4);
        System.out.println("Input: " + str4);
        System.out.println("Res: " + calculator.listToString(res4));
        System.out.println("Result: " + calculator.RPNCalculate(res4));
        System.out.println();

        String str5 = "100/tan(45)+13*10";
        List<String> expr5 = RPNCalculator.splitLine(str5);
        List<String> res5 = calculator.convertToRPN(expr5);
        System.out.println("Input: " + str5);
        System.out.println("Res: " + calculator.listToString(res5));
        System.out.println("Result: " + (int) calculator.RPNCalculate(res5));
        System.out.println();

        String str6 = "B=M[8,i+4,cos(a),k*4]^6";
        List<String> expr6 = RPNCalculator.splitLine(str6);
        List<String> res6 = calculator.convertToRPN(expr6);
        System.out.println("Input: " + str6);
        System.out.println("Res: " + calculator.listToString(res6));
        System.out.println();

        String str7 = " 1/2+(2+3)/(sin(9+2)^2+6/7)"; //1 2 / 2 3 + 9 2 + sin 2 ^ 6 7 / + / +
        List<String> expr7 = RPNCalculator.splitLine(str7);
        List<String> res7 = calculator.convertToRPN(expr7);
        System.out.println("Input: " + str7);
        System.out.println("Res: " + calculator.listToString(res7));
        System.out.println("Result: " + (int) calculator.RPNCalculate(res7));
        System.out.println();
    }
}
