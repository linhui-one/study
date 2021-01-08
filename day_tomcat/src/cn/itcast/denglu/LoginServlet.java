package cn.itcast.denglu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2020/11/11.
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        //验证码提取
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_seesion");
        //  验证码正确
        if (checkCode_session.equalsIgnoreCase(checkcode) && checkcode!=null){
            //账号密码正确
            if ("zhangsan".equals(username)&&"123".equals(password)){
                //存储数据，用户信息
               session.setAttribute("user",username);
               //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //登陆失败 存储数据到requset
                request.setAttribute("login_error","用户密码错误");
                //转发到登陆界面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        //验证码错误
        }else {
            //存储数据到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登陆界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
