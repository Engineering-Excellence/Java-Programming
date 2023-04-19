package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorIO {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Pattern pattern = Pattern.compile("^[-+]?\\d+\\s[-+*/]\\s[-+]?\\d+$");

        /*while (true) {
            System.out.print("계산식을 '숫자 연산자 숫자' 형식으로 입력하세요.(종료 Q): ");
            String calcExp = br.readLine();

            if (pattern.matcher(calcExp).matches()) {
                int num1 = Integer.parseInt(calcExp.split(" ")[0]);
                String op = calcExp.split(" ")[1];
                int num2 = Integer.parseInt(calcExp.split(" ")[2]);
                double res = switch (op) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> (double) num1 / num2;
                    default -> 0;
                };
                System.out.printf("%d %s %d = %.1f%n", num1, op, num2, res);
            } else if (calcExp.equalsIgnoreCase("Q")) {
                System.out.println("계산기를 종료합니다.");
                break;
            } else {
                System.out.print("잘못된 입력입니다. ");
            }
        }*/

        while (true) {
            try {
                System.out.print("계산식을 '숫자 연산자 숫자' 형식으로 입력하세요.(종료 Q): ");
                String calcExp = br.readLine();
                if (calcExp.equalsIgnoreCase("Q")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
                int num1 = Integer.parseInt(calcExp.split(" ")[0]);
                String op = calcExp.split(" ")[1];
                int num2 = Integer.parseInt(calcExp.split(" ")[2]);
                double res = switch (op) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> (double) num1 / num2;
                    default -> 0;
                };
                System.out.printf("%d %s %d = %.1f%n", num1, op, num2, res);
            } catch (Exception e) {
                System.out.print("잘못된 입력입니다. ");
            }
        }
    }
}
