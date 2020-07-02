package club.banyuan.controller;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/search.do")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao productDao = new ProductDaoImpl(JdbcUtil.getConnection());
            List<Product> list = productDao.search(request.getServerName());
            request.setAttribute("product",list);
            request.getRequestDispatcher("CategoryList.html").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
