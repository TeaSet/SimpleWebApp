package frontend;

import templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy on 12.10.2016.
 */
public class AnotherFrontend extends HttpServlet {
    String number = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> pageVariables = new HashMap<String, Object>();
            pageVariables.put("amount", number == null ? "" : number);
            response.getWriter().println(PageGenerator.getPage("statistics.html", pageVariables));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse responce) throws IOException {
        number = request.getParameter("Number");
        Map<String, Object> pageVariables = new HashMap<String, Object>();
            if (number == null) {
                responce.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
            else {
                responce.setStatus(HttpServletResponse.SC_OK);
            }
            pageVariables.put("amount", number == null ? "" : number);
            responce.getWriter().println(PageGenerator.getPage("statistics.html", pageVariables));
            responce.setContentType("text/html;charset=utf-8");

    }
}
