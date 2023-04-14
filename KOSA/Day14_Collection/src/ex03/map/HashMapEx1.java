package ex03.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx1 {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("kosa", "1234");
        map.put("daebo", "1004");
        map.put("kyle", "7895");
        map.put("kosa1", "12345");

        System.out.println("요소 개수: " + map.size());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("ID와 PW를 입력하세요.");
            System.out.print("ID: ");
            String id = sc.nextLine().trim();
            System.out.print("PW: ");
            String pw = sc.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("존재하지 않는 ID입니다.");
//                continue;
            } else {
                if (!map.get(id).equals(pw)) {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                } else {
                    System.out.println("ID와 PW가 일치합니다.");
                    break;
                }
            }
        }
    }
}
