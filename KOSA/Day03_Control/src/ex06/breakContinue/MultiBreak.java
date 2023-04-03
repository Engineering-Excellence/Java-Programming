package ex06.breakContinue;

public class MultiBreak {

    public static void main(String[] args) {

        boolean flag = true;    // 1 4 5

        first:
        {
            second:
            {
                third:
                {
                    int k = 100;
                    System.out.println("Before the break"); // 1
                    if (flag) break second; // break 식별자; → 식별자 위치까지 탈출
                    System.out.println("This won't execute");   // 2
                }   // End third
                System.out.println("Daebo 2nd");    // 3
            }   // End second
            System.out.println("This is after second break");   // 4
        }   // End first
        System.out.println("123456");   // 5
    }
}
