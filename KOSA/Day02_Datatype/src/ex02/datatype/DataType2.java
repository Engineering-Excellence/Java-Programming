///*
package ex02.datatype;

public class DataType2 {

    // 모든 자료형은 자신의 범위(크기)를 벗어나지 못 한다.
    public static void main(String[] args) {

        short sh = 32767;   // -32,768 ~ 32,767
        int num = 50000;    // -2,147,483,648 ~ 2,147,483,647

        // 작은 자료형이 큰 자료형에 대입될 때는 자동형변환(묵시적형변환)이 된다.
        num = sh;   // int(4byte) = short(2byte)
        System.out.println(sh + " : " + num);

//        num = -32769;
        num = 32770;    // Overflow: 32770 = (32767 + 1) + 2 → -32768 + 2 = -32766
        // 큰 자료형을 작은 자료형에 넣으려면 반드시 명시적형변환 해야한다. → 데이터 손실 발생
        sh = (short) num;   // 명시적 형변환
        System.out.println(sh + " : " + num);
    }
}
//*/

/*
package ex02.datatype;

public class DataType2 {

    // 모든 자료형은 자신의 범위(크기)를 벗어나지 못 한다.
    public static void main(String[] args) {

        short sh = 32767;   // -32,768 ~ 32,767
        int num = 50000;    // -2,147,483,648 ~ 2,147,483,647
        System.out.println(sh + " : " + num);

//        num = -32769;
        num = 32770;    // Overflow: 32770 = (32767 + 1) + 2 → -32768 + 2 = -32766
        sh = (short) num;   // 명시적 형변환
        System.out.println(sh + " : " + num);
    }
}
//*/

// 한 줄 주석
/* 여러 줄 주석 */