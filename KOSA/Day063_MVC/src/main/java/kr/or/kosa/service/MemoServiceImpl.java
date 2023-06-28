package kr.or.kosa.service;

import kr.or.kosa.dao.MemoDAO;
import kr.or.kosa.dao.MemoDAOImpl;
import kr.or.kosa.dto.MemoDTO;
import kr.or.kosa.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemoServiceImpl implements MemoService {

    private static final MemoService INSTANCE = new MemoServiceImpl();

    public static MemoService getInstance() {
        return INSTANCE;
    }

    private final MemoDAO memoDAO = MemoDAOImpl.getInstance();

    @Override
    public boolean insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("insert()");

        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        MemoDTO dto = new MemoDTO(id, email, content);

        SqlSession mapper = MyBatisUtil.getSession();
        int res = memoDAO.insertMemo(mapper, dto);
        mapper.commit();
        mapper.close();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        if (res > 0) {
            out.println("alert('등록 성공!');");
            out.println("location.href='/memo/list'");
        } else {
            out.println("alert('등록 실패');");
            out.println("location.href='/memo/index'");
        }
        out.println("</script>");
        out.flush();
        out.close();
        return res > 0;
    }

    @Override
    public boolean delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("delete()");

        String id = request.getParameter("id");
        log.info("id: {}", id);
        if (id == null) {
            log.error("메모 삭제 실패");
            return false;
        }
        SqlSession mapper = MyBatisUtil.getSession();
        int res = memoDAO.deleteMemo(mapper, id);
        mapper.commit();
        mapper.close();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        if (res > 0) {
            out.println("alert('삭제 성공!');");
            out.println("location.href='/memo/list'");
        } else {
            out.println("alert('삭제 실패');");
            out.println("location.href='/memo/index'");
        }
        out.println("</script>");
        out.flush();
        out.close();

        return res > 0;
    }

    @Override
    public boolean update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("update()");

        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        MemoDTO dto = new MemoDTO(id, email, content);
        SqlSession mapper = MyBatisUtil.getSession();
        int res = memoDAO.updateMemo(mapper, dto);
        mapper.commit();
        mapper.close();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        if (res > 0) {
            out.println("alert('수정 성공!');");
        } else {
            out.println("alert('수정 실패');");
        }
        out.println("location.href='/memo/list'");
        out.println("</script>");
        out.flush();
        out.close();
        return res > 0;
    }

    @Override
    public void seletcAll(HttpServletRequest request, HttpServletResponse response) {
        log.info("seletcAll()");

        SqlSession mapper = MyBatisUtil.getSession();
        request.setAttribute("list", memoDAO.selectAllMemo(mapper));
        mapper.close();
    }

    @Override
    public void selectOne(HttpServletRequest request, HttpServletResponse response) {
        log.info("selectOne()");

        String id = request.getParameter("id");
        SqlSession mapper = MyBatisUtil.getSession();
        MemoDTO dto = memoDAO.selectById(mapper, id);
        log.info("dto: {}", dto);
        request.setAttribute("memo", dto);
        mapper.close();
    }

    @Override
    public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("idCheck()");

        /*
            비동기 요청을 받아서
            전달한 id 값을 받은 후 request

            DB 연결

            return 값 받아서 뷰페이지 만들지 않고 out.print
        */

        String id = request.getParameter("id");
        log.info("id: {}", id);
        SqlSession mapper = MyBatisUtil.getSession();
        String isDbId = Objects.equals(memoDAO.isCheckById(mapper, id), null) ? "사용가능한 ID입니다." : "사용불가능한 ID입니다.";
        request.setAttribute("idCheck", isDbId);
        mapper.close();
    }
}
