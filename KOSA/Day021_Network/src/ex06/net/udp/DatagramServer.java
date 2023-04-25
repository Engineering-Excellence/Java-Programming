package ex06.net.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {   // UDP

    public static void main(String[] args) throws IOException {

        DatagramPacket dp;
        DatagramSocket ds = null;
        DataOutputStream dos = null;

        int port = 5000;
        String str;
        File file;

        try {
            System.out.println("UDP File Server Start");
            ds = new DatagramSocket(port);

            while (true) {
                dp = new DatagramPacket(new byte[65536], 65536);
                ds.receive(dp);

                str = new String(dp.getData(), 0, dp.getLength()).trim();

                if (str.equalsIgnoreCase("START")) {
                    System.out.println("데이터 전송중...");
                    file = new File("test.txt");

                    dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                } else if (str.equalsIgnoreCase("END")) {
                    System.out.println("END");
                    break;
                } else {
                    System.out.println(str);
                    assert dos != null;
                    dos.write(dp.getData(), 0, dp.getLength());
                }   // end if-else
            }   // end while
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert ds != null;
            ds.close();
            assert dos != null;
            dos.close();
        }
    }
}
