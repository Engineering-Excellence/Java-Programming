package com.tjoeun.lecture;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		
//		관계(비교) 연산자: 연산 결과는 무조곤 참(true) 또는 거짓(false)이다.
//		>(크다, 초과), >=(크거나 같다, 이상), <(작다, 미만), <=(작거나 같다, 이하
//		==(같다), !=(같지 않다)
		
//		논리 연산자: 연산 결과는 무조곤 참(true) 또는 거짓(false)이다.
//		&&: 논리곱(and), 두 조건이 모두 참일 경우에만 참, ~이고, ~이면서, ~중에서
//		||: 논리합(or), 두 조건 중에서 하나 이상 참일 경우에 참, ~또는, ~이거나
//		!: 논리 부정(not), 참은 거짓으로 거짓은 참으로 바꾼다.
		
//		연산자 우선순위
//		단항 연산자 => 이항 연산자(산술, 관계, 논리) => 삼항 연산자(?:) => 대입 연산자("="와 함께 사용)
//		() => ! => 산술 연산자(*, /, % => +, -) => 관계 연산자(>, >=, <, <=) => 관계 연산자(==, !=)
//		논리 연산자(&& => ||)
		
//		if (조건식) {
//			조건식이 참일 경우 실행할 문장;
//			...;
//		} else {
//			조건식이 거짓일 경우 실행할 문장;
//			...;
//		}
//		조건식이 거짓일 경우 실행할 문장이 없다면 else 이하를 생략하면 된다.
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();
		
		if (age >= 18) {
			System.out.println("투표권이 있습니다.");
		} else {
			System.out.println("투표권이 없습니다.");
		}
		
	}
	
}

















