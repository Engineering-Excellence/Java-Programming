package ex05.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("USAGE: java TcpMultiChatClient nickName?");
            System.exit(1);
        }
        String ip = "localhost";    // 127.0.0.1 or 192.168.0.115
//        String ip = "192.168.0.61";
        try {
            Socket s = new Socket(ip, 7777);
            System.out.println("Server Connected");
            Thread sender = new Thread(new ClientSender(s, args[0]));
            Thread receiver = new Thread(new ClientReceiver(s));

            sender.start();   // run() 메서드 유도
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   // end main

    static class ClientSender extends Thread {  // Inner class

        Socket s;
        DataOutputStream dos;
        String name;

        public ClientSender(Socket s, String name) {

            this.s = s;
            try {
                dos = new DataOutputStream(s.getOutputStream());
                this.name = name;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);    // 키보드로부터 입력 받기
            try {
                if (dos != null) dos.writeUTF(name);
                while (dos != null) dos.writeUTF(String.format("[%s] %s", name, sc.nextLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   // end run()
    }

    static class ClientReceiver extends Thread {    // Inner class

        Socket s;
        DataInputStream dis;

        public ClientReceiver(Socket s) {

            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            while (dis != null) {
                try {
                    System.out.println(dis.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }   // end run()
    }
}
