package lesson23.task1;
/*Написать приложение, которое при запуске будет сообщать в консоль что оно
работает. На любой запрос в консоли должна отображаться запись со временем этого
запроса.*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet(urlPatterns = "/*")
public class TimeServlet extends HttpServlet {

    public static final String SERVLET_TIME_ATTRIBUTE_NAME = "tmAttr";
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("App is working");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute(SERVLET_TIME_ATTRIBUTE_NAME, LocalTime.now());
        System.out.println("Request time of %s is %s".formatted(req.getRequestURI(), getServletContext().getAttribute(SERVLET_TIME_ATTRIBUTE_NAME)));
    }
}
