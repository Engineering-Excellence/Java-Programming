package edu.kosa.controller;

import edu.kosa.model.InfoDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "InfoController", value = "/info")
public class InfoController extends HttpServlet {

  private static final long serialVersionUID = 931166595258187621L;

  @Override
  public void init() {
    log.info("init()");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info("doGet()");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info("doPost()");

    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String tel = request.getParameter("tel");
    InfoDTO infoDTO = new InfoDTO(name, addr, tel);

    request.setAttribute("infoDTO", infoDTO);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/infoView.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  public void destroy() {
    log.info("destroy()");
  }
}
