package ex02.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlEx {

    public static void main(String[] args) throws MalformedURLException, IOException {

//        URL url = new URL("https://www.google.com/");   // MalformedURLException 예외 발생
        URL url = new URL("https://www.sw.or.kr/site/sw/main.do");   // MalformedURLException 예외 발생

        // System.in: 키보드로부터 표준 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));    // IOException 예외 발생

        String inputLine;
        while ((inputLine = br.readLine()) != null) {   // IOException 예외 발생
            System.out.println(inputLine);
        }
        br.close();
    }
}
