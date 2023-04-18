package ex03.io;

import java.io.IOException;

public class InputStreamEx {

    public static void main(String[] args) {

        System.out.print("input: ");

        try {
            int num;
            while ((num = System.in.read()) != -1) {
                if (num == 10 || num == 13 || num == 32) continue;
                if (num == 113 || num == 81) break; // 'q' || 'Q'
                char c = (char) num;
                System.out.println(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
