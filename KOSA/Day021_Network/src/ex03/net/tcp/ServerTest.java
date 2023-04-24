package ex03.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {   // Socket 2개 필요

    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        System.out.println("Server Start!");

        try {
            ss = new ServerSocket(9000);    // 0 ~ 1024 포트는 예약되어 있음
            s = ss.accept();

            // I/O
            InputStream is = s.getInputStream();    // Read
            OutputStream os = s.getOutputStream();  // Write

            byte[] serverBuffer = new byte[100];
            System.out.println("byte read: " + is.read(serverBuffer));
            System.out.println(new String(serverBuffer));

            String serverMsg = "Hello, Client!";
            os.write(serverMsg.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                s.close();
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
