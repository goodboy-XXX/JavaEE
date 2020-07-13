package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.SelectService;
import club.banyuan.service.impl.SelectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/select.do")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String inputName = request.getParameter("inputName");
        String description = request.getParameter("description");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String startPrice = request.getParameter("startPrice");
        Integer integer = Integer.valueOf(startPrice);
        SelectService selectService = new SelectServiceImpl();
        try {
            List<Product> list = selectService.selectByInput(inputName, description, startTime, endTime, integer);
            HttpSession session = request.getSession();
            session.setAttribute("list",list);
            if (list != null){
                request.getRequestDispatcher("select.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("product.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
