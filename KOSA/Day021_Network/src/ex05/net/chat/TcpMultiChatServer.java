package ex05.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TcpMultiChatServer {   // Outer class

    Map<Object, Object> clients;    // key: 닉네임, value: 메시지

    public TcpMultiChatServer() {   // 생성자: 필드 초기화

        clients = new HashMap<>();  // HashMap 객체 생성
        Collections.synchronizedMap(clients);   // 동기화
    }

    public void init() throws IOException {   // User Method

        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(7777);
            System.out.println("Server Start");

            while (true) {
                s = ss.accept(); // 응답 대기, 클라이언트 소켓
                System.out.printf("[%s:%s]에서 접속하셨습니다.%n", s.getInetAddress(), s.getPort());
                ServerReceiver thread = new ServerReceiver(s);  // User class
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert s != null;
            s.close();
        }
    }   // end init()

    class ServerReceiver extends Thread {   // Inner class

        Socket s;   // Client Socket
        DataInputStream dis = null;    // readXX() - XX: 자료형
        DataOutputStream dos = null;   // writeXX()

        public ServerReceiver(Socket s) {

            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());  // 네트워크 통해서 읽기
                dos = new DataOutputStream(s.getOutputStream());    // 네트워크 통해서 쓰기
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   // end constructor

        public void sendToAll(String msg) {

            Iterator<Object> itr = clients.keySet().iterator(); // key 출력

            while (itr.hasNext()) {
                try {
                    DataOutputStream dos = (DataOutputStream) clients.get(itr.next());  // 해당 key로 value 출력
//                    System.out.printf("dos.toString(): %s%n", dos.toString());
                    dos.writeUTF(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() { // 스레드 실행부(구현부)

            String name = "";
            try {
                name = dis.readUTF();
                sendToAll(String.format("#%s 님이 입장하셨습니다.", name));

                clients.put(name, dos); // HashMap 넣기
                System.out.printf("현재 서버 접속자 수는 %d명입니다.%n", clients.size());    // 접속자 수 확인

                while (dis != null) {
                    sendToAll(dis.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                sendToAll(String.format("#%s님이 나가셨습니다.", name));
                clients.remove(name);   // 접속자 수 제거
                System.out.printf("[%s:%s]에서 접속 종료하셨습니다.%n", s.getInetAddress(), s.getPort());
            }   // end try
        }
    }

    public static void main(String[] args) throws IOException {

        new TcpMultiChatServer().init();
    }
}   // Outer class
