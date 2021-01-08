package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2020/11/8.
 */
@WebServlet("/requestDome1")
public class RequestDome1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println(method);

        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        String queryString = request.getQueryString();
        System.out.println(queryString);


    }
}
