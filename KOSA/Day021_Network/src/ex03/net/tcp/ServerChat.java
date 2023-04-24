package ex03.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerChat {

    public static void main(String[] args) throws IOException {

        int port = 8000;
        ServerSocket server = new ServerSocket(port);
        Socket client;
        System.out.println("Chat Server Start!");

        while (true) {
            client = server.accept();
            InputStream is = client.getInputStream();   // 네트워크 통해서 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintStream ps = new PrintStream(System.out);

            ps.print(client.getInetAddress().getHostAddress());
            String str = br.readLine();
            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            String message = new String(buffer, StandardCharsets.UTF_8);

            ps.printf("에서 수신 메시지: %s%n", message);
            br.close();
            client.close();
        }   // end while
    }
}
