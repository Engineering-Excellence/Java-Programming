package ex02.network;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlEx2 {

    public static void main(String[] args) throws MalformedURLException {

        /*
            ?속성=값&속성=값
            https://www.google.co.kr/
            search?
            q=%EA%B9%80%EC%97%B0%EC%95%84   // kim+yuna
            &client=safari
            &source=hp
            &ei=XhJGZPauM4S5hwPTk5mQCw
            &iflsig=AOEireoAAAAAZEYgbsYk-l3qWS0mU4KCgkmUZPm1pCm4
            &ved=0ahUKEwj21b6u48H-AhWE3GEKHdNJBrIQ4dUDCAo
            &uact=5
            &oq=%EA%B9%80%EC%97%B0%EC%95%84
            &gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMgUIABCABDILCAAQgAQQsQMQgwEyCAgAEIAEELEDMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOhEILhCABBCxAxCDARDHARDRAzoNCC4QgAQQxwEQ0QMQCjoLCC4QgAQQxwEQ0QM6BAgAEAM6CwguEIAEELEDEIMBOgcILhDUAhADOgUILhCABDoICC4QgAQQsQM6DgguEIAEELEDEIMBENQCOgsILhCABBCxAxDUAjoICC4QgAQQ1AI6DgguEIMBENQCELEDEIAEUABYhglgoQpoAXAAeACAAU6IAZQFkgEBOZgBAKABAbABAA
            &sclient=gws-wiz
         */

//        URL url = new URL("https://www.google.co.kr/search?q=kim+yuna&client=safari&source=hp&ei=XhJGZPauM4S5hwPTk5mQCw&iflsig=AOEireoAAAAAZEYgbsYk-l3qWS0mU4KCgkmUZPm1pCm4&ved=0ahUKEwj21b6u48H-AhWE3GEKHdNJBrIQ4dUDCAo&uact=5&oq=%EA%B9%80%EC%97%B0%EC%95%84&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMgUIABCABDILCAAQgAQQsQMQgwEyCAgAEIAEELEDMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOhEILhCABBCxAxCDARDHARDRAzoNCC4QgAQQxwEQ0QMQCjoLCC4QgAQQxwEQ0QM6BAgAEAM6CwguEIAEELEDEIMBOgcILhDUAhADOgUILhCABDoICC4QgAQQsQM6DgguEIAEELEDEIMBENQCOgsILhCABBCxAxDUAjoICC4QgAQQ1AI6DgguEIMBENQCELEDEIAEUABYhglgoQpoAXAAeACAAU6IAZQFkgEBOZgBAKABAbABAA&sclient=gws-wiz");
        URL url = new URL("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=kim+yuna");

        // URL이 갖고 있는 함수 사용
        System.out.println("프로토콜: " + url.getProtocol());
        System.out.println("호스트와 포트: " + url.getAuthority());
        System.out.println("호스트: " + url.getHost());
        System.out.println("포트: " + url.getPort());
        System.out.println("경로: " + url.getPath());
        System.out.println("질의: " + url.getQuery());
        System.out.println("파일명: " + url.getFile());
        System.out.println("참조: " + url.getRef());
    }
}
