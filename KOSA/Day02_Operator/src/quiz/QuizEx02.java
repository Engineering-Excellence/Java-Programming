package quiz;

import java.util.Scanner;

// 문제] 이름, 주소, 연락처 입력 받아서 출력하기
public class QuizEx02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // next(): 공백 인식 X
        // nextLine(): 공백 포함 O

        System.out.print("이름을 입력하세요.: ");
        String name = scanner.next();
        System.out.print("주소를 입력하세요.: ");
        String addr = scanner.next();
        System.out.print("연락처를 입력하세요.: ");
        String tel = scanner.next();

        scanner.close();

        System.out.printf("%n이름: %s%n주소: %s%n연락처: %s%n", name, addr, tel);
    }
}
