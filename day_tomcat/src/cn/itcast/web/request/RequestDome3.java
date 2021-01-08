package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by lenovo on 2020/11/8.
 */
@WebServlet("/requestDome3")
public class RequestDome3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置流的编码
        request.setCharacterEncoding("utf-8");
        //根据参数名称获取参数值

        System.out.println("Dome3....");
        request.getRequestDispatcher("/requestDome4").forward(request,response);


//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        System.out.println(username);
//        System.out.println(password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

this.doPost(request,response);


    }
}
