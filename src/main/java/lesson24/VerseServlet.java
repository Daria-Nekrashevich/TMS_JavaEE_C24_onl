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

    public static final String SERVLET_URL_NAME = "http://localhost:63342/JavaEE/src/main/webapp/verse.html";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/verse.html").forward(req, resp);
        /*resp.sendRedirect(SERVLET_URL_NAME);*/
    }
}
