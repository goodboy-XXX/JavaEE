package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.ProductService;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.ProductServiceImpl;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userService.getLoginUser(username, password);
            ProductService productService = new ProductServiceImpl();
            List<Product> list = productService.getAllProducts();
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("list", list);
            if (user != null) {
                request.getRequestDispatcher("product.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.html").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
