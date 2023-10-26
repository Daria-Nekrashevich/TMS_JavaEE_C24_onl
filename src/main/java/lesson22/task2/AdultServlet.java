package lesson22.task2;
/*Создать сервлет который на вход принимает возраст, а в ответе возвращает
информацию, совершеннолетний или нет.*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/check")
public class AdultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckIfAdult checkIfAdult = new CheckIfAdult();
        Integer age = Integer.valueOf(req.getParameter("age"));
        resp.getWriter().println(checkIfAdult.checkIfAdult(age));
    }


}
