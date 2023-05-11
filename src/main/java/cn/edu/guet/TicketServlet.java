package cn.edu.guet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("余票查询");

        String fromStation = request.getParameter("fromStation");
        String toStation = request.getParameter("toStation");
        String departureDate = request.getParameter("departureDate");

        System.out.println(fromStation);
        System.out.println(toStation);
        System.out.println(departureDate);

        String allTickets = TicketSearch.search(fromStation, toStation, departureDate);

//        设置响应类型
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(allTickets);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
