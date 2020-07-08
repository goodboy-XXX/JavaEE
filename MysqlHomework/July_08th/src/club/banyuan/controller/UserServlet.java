package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/login.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl();
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        User user;
        try {
            user = userService.login(userName, pwd);
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            request.getRequestDispatcher("login.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
