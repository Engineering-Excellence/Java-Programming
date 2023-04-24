package ex03.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {   // Socket 1개 필요

    public static void main(String[] args) {

        Socket s = null;

        try {
            s = new Socket("127.0.0.1", 9000);  // 서버 IP & 포트 번호

            // I/O
            InputStream is = s.getInputStream();    // Read
            OutputStream os = s.getOutputStream();  // Write

            String clientMsg = "Hi, Server!";
            os.write(clientMsg.getBytes());

            byte[] clientBuffer = new byte[100];
            System.out.println("byte read: " + is.read(clientBuffer));
            System.out.println(new String(clientBuffer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
