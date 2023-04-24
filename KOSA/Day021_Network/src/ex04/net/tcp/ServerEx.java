package ex04.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

    public static void main(String[] args) {

        BufferedReader br;
        BufferedReader stdIn;
        BufferedWriter bw;
        ServerSocket ss; // socket 1
        Socket s = null;    // socket 2
        System.out.println("Server Connected!");

        try {
            ss = new ServerSocket(9999);
            s = ss.accept();    // 클라이언트 소켓, 응답 대기

            br = new BufferedReader(new InputStreamReader(s.getInputStream())); // 네트워크를 통해서 데이터 읽기

            // 키보드로부터의 입력 스트림
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            // 클라이언트로의 출력 스트림
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String inputMsg;

            while (true) {
                inputMsg = br.readLine();   // 클라이언트에서 한 행의 문자열 읽기

                // 클라이언트가 "EXIT"을 보내면 연결 종료
                if (inputMsg.equalsIgnoreCase("EXIT")) break;

                System.out.println(inputMsg);   // 클라이언트가 보낸 메시지 출력

                System.out.print("Message Input: ");
                String outputMsg = stdIn.readLine();    // 키보드에서 한 행의 문자열 읽기
                bw.write(s.getInetAddress() + " 서버 > " + outputMsg + "\n");
                bw.flush();
            }   // end while
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert s != null;
                s.close();  // 클라이언트 소켓 종료
//                ss.close();
            } catch (IOException e) {
                System.out.println("클라이언트와의 채팅 중 오류 발생");
            }
        }
    }
}
