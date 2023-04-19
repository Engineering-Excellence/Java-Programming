package ex09.file;

import java.io.*;

public class FileObjectSave {
    public static void main(String[] args) throws IOException { // 회원가입
        String name = null;
        String id = null;
        String pwd = null;
        boolean gender = true;
        int age = 0;
        String phone = null;
        String temp = null;

        /*InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oos = null;
        File file = new File("members.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file, true);  // append mode: true
            oos = new ObjectOutputStream(fos);

            System.out.println("--------------------회원 정보 입력 하기 ------------------------------");
            System.out.print("이름 >> ");
            name = br.readLine();
            System.out.print("ID >> ");
            id = br.readLine();
            System.out.print("Password >> ");
            pwd = br.readLine();

            System.out.print("성별(m,f) >> ");
            temp = br.readLine();
            gender = temp.equalsIgnoreCase("m");

            System.out.print("나이 >> ");
            age = Integer.parseInt(br.readLine());
            System.out.print("전화번호 >> ");
            phone = br.readLine();
            oos.writeObject(name);
            oos.writeObject(id);
            oos.writeObject(pwd);
            oos.writeObject(gender);
            oos.writeObject(age);
            oos.writeObject(phone);
            System.out.println("members.txt  save!!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
        } // try end
    }
}






