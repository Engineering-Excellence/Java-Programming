package ex04.net.tcp;

import java.io.*;
import java.net.Socket;

public class ClientEx {

    public static void main(String[] args) {

        BufferedReader br;
        BufferedReader stdIn;
        BufferedWriter bw;
        Socket s = null;    // socket

        try {
            s = new Socket("192.168.0.108", 9999);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String outputMsg;

            while (true) {
                System.out.print("Message Input: ");
                outputMsg = stdIn.readLine();

                if (outputMsg.equalsIgnoreCase("EXIT")) {
                    bw.write(outputMsg);
                    bw.flush();
                    break;
                }   // end if

                // 키보드에서 읽은 문자열 전송
                bw.write(s.getInetAddress() + " 클라이언트 > " + outputMsg + "\n");
                bw.flush();

                String inputMsg = br.readLine();
                System.out.println(inputMsg);
            }   // end while
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert s != null;
                s.close();  // 클라이언트 소켓 종료
            } catch (IOException e) {
                System.out.println("서버와의 채팅 중 오류 발생");
            }
        }
    }
}
