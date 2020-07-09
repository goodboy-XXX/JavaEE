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

@WebServlet(name = "UserServlet",urlPatterns = "/login.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userService.getLoginUser(username, password);
            request.getSession().setAttribute("user",user);
            if(user != null){
                request.getRequestDispatcher("product.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("login.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
