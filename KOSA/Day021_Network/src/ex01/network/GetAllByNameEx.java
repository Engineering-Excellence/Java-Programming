package ex01.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class GetAllByNameEx {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strUrl = null;
        InetAddress[] addresses;

        System.out.print("Site Address: ");
        try {
            strUrl = br.readLine(); // 예외 발생
            addresses = InetAddress.getAllByName(strUrl);   // 예외 발생

            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
