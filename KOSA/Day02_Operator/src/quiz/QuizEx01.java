package quiz;

public class QuizEx01 {

    public static void main(String[] args) {

        /*
        int pay = 567890;
        System.out.printf("만원: %d장%n", pay / 10000);
        pay %= 10000;
        System.out.printf("천원: %d장%n", pay / 1000);
        pay %= 1000;
        System.out.printf("백원: %d개%n", pay / 100);
        pay %= 100;
        System.out.printf("십원: %d개%n", pay / 10);
        */

        // 1. 변수 선언
        int pay = 567890;
        int man, cheon, baek, sip;  // 몫 저장변수
        int m_na, ch_na, b_na;  // 나머지 저장변수

        // 2. 메시지 출력 및 입력 받기

        // 3. 처리(계산)
        man = pay / 10000;      m_na = pay % 10000;
        cheon = m_na / 1000;    ch_na = m_na % 1000;
        baek = ch_na / 100;     b_na = ch_na % 100;
        sip = b_na / 10;

        // 4. 결과 출력(화면)
        System.out.println("\n만원: " + man
                            + "장\n천원: " + cheon
                            + "장\n백원: " + baek
                            + "개\n십원: " + sip + "개");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("만원: " + pay / 10000
                + "장\n천원: " + (pay % 10000) / 1000
                + "장\n백원: " + ((pay % 10000) % 1000) / 100
                + "개\n십원: " + (((pay % 10000) % 1000) % 100) / 10 + "개");

        System.out.println("------------------------------------------------------------------------------------------");

        int su = 12345;
        System.out.printf("%d시 %d분 %d초", su / 3600, (su % 3600) / 60, (su % 3600) % 60);
    }
}

/*
    문제1] 월급을 단위로 계산하기
        int pay = 567890;

            result:
                    만원: 56장
                    천원: 7장
                    백원: 8개
                    십원: 9개

    문제2] int su = 12345;
            시 : 분 : 초
 */