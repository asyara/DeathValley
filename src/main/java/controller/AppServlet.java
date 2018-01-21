package controller;

import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resultRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resultRequest(req, resp);
    }

    protected void resultRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service srv = new Service();
        String action = request.getParameter("action");
        if ("getRichestUser".equals(action)) {
            request.setAttribute("richestUser", srv.getRichestUser().getName() + " " + srv.getRichestUser().getSurname());
        } else if ("getSum".equals(action)) {
            request.setAttribute("summa", srv.getAccountsSum());
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}

