package quiz;

import java.util.Arrays;
import java.util.Scanner;

// 입력함수 input()  
// 출력함수 output()
// 총점&평균 함수 total_avg(~)
// 학점 함수 grade(~)
public class ScoreFunc {

	public static void input(String[] name, int[][] arr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d 번째 학생 이름: ", i + 1);
			name[i] = sc.next();

			for (int j = 0; j < arr[0].length - 1; j++) {
				switch (j) {
				case 0:
					System.out.println("국어점수 입력: ");
					break;
				case 1:
					System.out.println("영어점수 입력: ");
					break;
				case 2:
					System.out.println("전산점수 입력: ");
					break;
				} // switch end
				arr[i][j] = sc.nextInt();

			}
		}
	}
	
	public static void output(int SU, String[] name, int[][] arr, double[] avg, char[] grade, double[] scorePan)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.println(name[i] + "님의 성적표");
			System.out.println("국어: " + arr[i][0] + "\t영어: " + arr[i][1] + "\t전산: " + arr[i][2]);
			System.out.printf("총점: %d 평균 : %.1f 평점(학점) : %c ", arr[i][3], avg[i], grade[i]);

			for (int j = 0; j < scorePan.length; j++) {
				if (scorePan[j] == avg[i]) {
					System.out.printf("석차(등수) : %d\n", SU - j);
				}
			}
			line();
		}
	}
	public static void 총점(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length - 1; j++) {
				arr[i][3] += arr[i][j];
			}
		}
	}

	public static void 평균(int[][] arr, double[] avg, int NO) {

		for (int i = 0; i < arr.length; i++) {
			avg[i] = (double) arr[i][3] / NO;
		}
	}

	public static char 학점(double avg) {

		char grade = ' ';

		switch ((int) avg / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}// switch end

		return grade;
	}

	public static void main(String[] args) {

		int SU = 2, NO = 3;
		int[][] arr = new int[SU][NO + 1]; // 인원수, 과목수
		String[] name = new String[SU];
		double[] avg = new double[SU];
		char[] grade = new char[SU];

		input(name, arr);
	
		총점(arr);
		평균(arr, avg, NO);
		for (int i = 0; i < avg.length; i++) {
			grade[i] = 학점(avg[i]);
		}

		double[] scorePan = Arrays.copyOf(avg, SU);
		Arrays.sort(scorePan);
		
		output(SU,name, arr, avg, grade,scorePan);

	}

	private static void line() {
		System.out.println("----------------------------");
	}
}
