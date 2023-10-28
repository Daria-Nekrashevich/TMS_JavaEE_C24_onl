package lesson22.task1;
/*Создать приложение, которое при переходе на следующие урлы будет выдавать
результат:
/minsk - время в Минске
/washington - время в Вашингтоне
/beijing - время в Пекине*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class TimeInCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Integer> mapCityAndTime = Map.of("/JavaEE_war_exploded/minsk", 0, "/JavaEE_war_exploded/washington", -4, "/JavaEE_war_exploded/beijing", 8);
        System.out.println(req.getRequestURI().toString());
        int time = mapCityAndTime.get(req.getRequestURI().toString());
        LocalTime timeNow = LocalTime.now();
        String text = "Time in city: %s".formatted(Objects.toString(timeNow.plusHours(time)));
        resp.getWriter().println(text);
    }
}
