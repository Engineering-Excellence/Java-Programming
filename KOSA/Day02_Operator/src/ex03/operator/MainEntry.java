package ex03.operator;

import java.util.Scanner;

// 최단산쉬관논삼대콤
public class MainEntry {

    public static void main(String[] args) {

        // 3항(조건) 연산자 → 조건 ? 참 : 거짓;

        int x, y, z = 0, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Integer Data 2 Inputs: ");

        x = sc.nextInt();
        y = sc.nextInt();
//        if (x > y) result = x;
//        else result = y;

        result = (x > y) ? x : y;
        System.out.printf("max = %d%n", result);

        String str = null;
        System.out.print("year: ");
        int year = sc.nextInt();

        // if 판정 ?

        str = (year == 2000) ? "맞네" : "틀리네";
        System.out.printf("%d년도: %s%n", year, str);

        result = (x > y) ? x
                : (y > z) ? y
                : (x > z) ? x : z;

        System.out.println("------------------------------------------------------------------------------------------");

        /*
            논리 연산자: &, &&(AND), |, ||(OR), ^(XOR), !(NOT)
            2진: &, |, ^ → 2진수로 변환한 뒤 비트연산하여 값으로 출력
            10진: &&, ||, ! → 연산하여 true/false 출력
         */

        // 2진 논리 결과 → 값
        System.out.println(4 & 7);
        System.out.println(4 | 7);
        System.out.println(4 ^ 7);

        // 10진 논리 결과 → true/false
        x = 10;
        y = 20;
        z = 30;
        boolean flag = false;

//        flag = (x < y) && (y < z);
        flag = (x > y) && (y < z);  // '&&' 연산일 때 앞의 값이 거짓이면 뒤는 연산을 수행하지 않는다.
        System.out.println(flag);

        flag = (x < y) || (y < z);  // '&&' 연산일 때 앞의 값이 참이면 뒤는 연산을 수행하지 않는다.
//        flag = (x > y) || (y > z);
        System.out.println(flag);

        System.out.println(!flag);
    }
}
