package ex01.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainEntry {

    public static void main(String[] args) {

        String host = "127.0.0.1";

        try {
        InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                System.out.println(address.getCanonicalHostName());
            }
        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
