package ex02.datatype;

public class DataType3 {

    // 진법 -
    public static void main(String[] args) {

        int su = 10;

        System.out.printf("10진수: %d%n", su);
        System.out.println("2진수: " + Integer.toBinaryString(su));
        System.out.printf("8진수: %o%n", su);
        System.out.printf("16진수: %x, %X%n", su, su);

        // 진법 변환
        System.out.printf("0%o = %d%n", 012, 012); // 012 = 10
        System.out.printf("0x%X = %d%n", 0xA, 0xA); // 0xA = 10
    }
}


/*
    10진수: 0 ~ 9
    8진수: 0 ~ 7
    16진수: 0 ~ 9, A, B, C, D, E, F

    10 = 012 = 0xA
 */