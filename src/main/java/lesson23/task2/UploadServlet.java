package lesson23.task2;
/*
/load-book - который позволит загружать свои книги на сервер.*/


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/load-book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:63342/JavaEE/src/main/webapp/load-book.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        System.out.println("Description" + description);
        String message = "";
        try {
            Part part = req.getPart("file");
            part.write(getFileName(part));
            message = "File is uploaded";
        } catch (Exception ex) {
            message = "Error: " + ex.getMessage();
        }
        resp.getWriter().println(message);


    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (!contentDisposition.contains("filename=")) {
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;
        return contentDisposition.substring(beginIndex, endIndex);
    }
}
