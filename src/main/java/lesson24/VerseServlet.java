package lesson24;
/*При переходе на /verse пользователь должен получить страницу как изображено
ниже(фотографию можно использовать любую):*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/verse")
public class VerseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:63342/JavaEE/src/main/webapp/WEB-INF/verse.html");
    }
}
