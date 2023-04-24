package ex01.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAllByNameEx2 {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        showLocalhost(address);

        address = InetAddress.getByName("www.sw.or.kr");
        showLocalhost(address);

        byte[] addr = new byte[4];  // 192.168.0.115
        addr[0] = (byte) 192;
        addr[1] = (byte) 168;
        addr[2] = (byte) 0;
        addr[3] = (byte) 115;

        address = InetAddress.getByAddress(addr);
        showLocalhost(address);

        InetAddress[] arr = InetAddress.getAllByName("www.naver.com");
        for (InetAddress el : arr) {
            showLocalhost(el);
        }
    }

    private static void showLocalhost(InetAddress address) {
        System.out.println("로컬호스트 이름: " + address.getHostName());
        System.out.println("로컬호스트 이름: " + address.getCanonicalHostName());
        System.out.println("로컬호스트 IP 주소: " + address.getHostAddress());
        System.out.println("-".repeat(40));
    }
}
