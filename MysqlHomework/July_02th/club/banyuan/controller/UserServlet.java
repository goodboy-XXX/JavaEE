package club.banyuan.controller;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.InsertService;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.InsertServiceImpl;
import club.banyuan.service.impl.UserServiceImpl;
import club.banyuan.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/login.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        //注册
        try {
            User user = new User();
            user.setLoginName(request.getParameter("loginName"));
            user.setUserName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            user.setSex(Integer.valueOf(request.getParameter("sex")));
            user.setIdentityCode(Integer.valueOf(request.getParameter("identityCode")));
            user.setEmail(request.getParameter("email"));
            user.setMobile(Integer.valueOf(request.getParameter("mobile")));
            user.setType(Integer.valueOf(request.getParameter("type")));

            UserDao userDao = new UserDaoImpl(JdbcUtil.getConnection());
            int i = userDao.add(user);
            if (i > 0) {
                response.sendRedirect("Login.html");
            } else {
                response.sendRedirect("Regist.html");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }


        //登陆
//        UserService userService = new UserServiceImpl();
//        try {
//            User user = userService.login(loginName, password);
//            if (user != null){
//                request.setAttribute("user",user);
//                request.getRequestDispatcher("index.jsp").forward(request,response);
//                return;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        request.getRequestDispatcher("Login.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
