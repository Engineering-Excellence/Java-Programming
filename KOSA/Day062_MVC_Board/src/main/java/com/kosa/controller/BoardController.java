package com.kosa.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebServlet(name = "BoardController", value = "/*.do")
public class BoardController extends HttpServlet {  // Super Controller

    private static final long serialVersionUID = 4473223163029310318L;

    protected void process(HttpServletRequest request, HttpServletResponse response) {
        log.info("process()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("doGet()");
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");
        process(request, response);
    }

    @Override
    public void init() {
        log.info("init()");
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}