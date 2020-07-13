package club.banyuan.controller;

import club.banyuan.entity.Manager;
import club.banyuan.service.ManagerService;
import club.banyuan.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerServlet",urlPatterns = "/manager.do")
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ManagerService managerService = new ManagerServiceImpl();
        String managerName = request.getParameter("managerName");
        String password = request.getParameter("password");
        try {
            Manager manager = managerService.getManager(managerName, password);
            if (manager != null){
                request.getRequestDispatcher("managerProduct.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("manager.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
