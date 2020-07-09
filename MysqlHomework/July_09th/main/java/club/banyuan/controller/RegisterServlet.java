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

@WebServlet(name = "RegisterServlet", urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPwd(request.getParameter("password"));
        user.setIdentityID(request.getParameter("identityID"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setAddress(request.getParameter("address"));
        user.setPost(Integer.valueOf(request.getParameter("post")));

        request.getSession().setAttribute("user",user);
        UserService userService = new UserServiceImpl();
        try {
            User registerUser = userService.getRegisterUser(user);
            if (registerUser != null){
                request.getRequestDispatcher("product.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
