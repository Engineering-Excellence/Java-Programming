package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GiftService {

    boolean register(HttpServletRequest request, HttpServletResponse response);

    int search(HttpServletRequest request, HttpServletResponse response);
}
