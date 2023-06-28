package com.kosa.boardAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface CommandAction {

    String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
