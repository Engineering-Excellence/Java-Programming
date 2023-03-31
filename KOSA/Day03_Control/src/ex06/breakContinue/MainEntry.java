package ex06.breakContinue;

public class MainEntry {

    public static void main(String[] args) {

        /*for (int i = 1; i < 11; i++) {
            if (i == 7) break;
            System.out.println(i);
        }*/

        /*for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 7) break;
                System.out.println("i = " + i);
                System.out.println("j = " + j);
            }   // j end
            System.out.println();
        }   // i end*/

        for (int i = 1; i < 11; i++) {
            if (i == 7) continue;
            System.out.println(i);
        }
    }
}
