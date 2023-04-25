package ex06.net.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {

    public static void main(String[] args) {

        DatagramPacket dp = null;
        DatagramSocket ds = null;
        DataInputStream dis = null;
        BufferedReader br = null;

        int port = 5000;
        String str;
        byte[] buffer = null;

        try {
            System.out.println("UDP File Client");
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("전송 대상(Server IP): ");
            String ipAddress = br.readLine();
            System.out.print("전송 파일명(확장자 포함): ");
            String fileName = null;
            fileName = br.readLine();

            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("파일이 존재하지 않습니다.");
                System.exit(-1);
            }

            str = "start";
            buffer = str.getBytes();
            ds = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName(ipAddress); // 문자열 ip 주소를 실제 ip 주소로 변경
            dp = new DatagramPacket(buffer, buffer.length, inetAddress, port);
            ds.send(dp);    // 송신

            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            buffer = new byte[65536];

            while (true) {
                int count = dis.read(buffer, 0, buffer.length);

                if (count == -1) break;

                dp = new DatagramPacket(buffer, count, inetAddress, port);
                ds.send(dp);
            }   // end while

            str = "end";
            buffer = str.getBytes();

            dp = new DatagramPacket(buffer, buffer.length, inetAddress, port);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
                assert dis != null;
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
