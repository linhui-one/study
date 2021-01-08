package cn.itcast.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2020/11/10.
 */
@WebServlet("/cookieServlet3")
public class CookieServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Boolean a = false;
        //不是第一次
        if (cookies!=null && cookies.length>0 &&a==true){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("ms".equals(name)){
                    String value = cookie.getValue();
                    //URL解码
                    String decode = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来上次的访问时间为"+decode);
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
                    String format = sdf.format(date);
                    //url编码
                     format = URLEncoder.encode(format,"utf-8");

                    cookie.setValue(format);
                    cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                    break;
                }

            }
        }
        //第一次访问
        if(cookies == null||cookies.length==0 || a==false){
            a=true;
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
            String value = sdf.format(date);
            //url编码
            String encode = URLEncoder.encode(value, "utf-8");
            Cookie cookie = new Cookie("ms",encode);
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
            response.getWriter().write("您是第一次登陆，您的登陆时间是"+value);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
