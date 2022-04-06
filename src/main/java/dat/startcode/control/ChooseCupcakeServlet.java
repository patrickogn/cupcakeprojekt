package dat.startcode.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "ChooseCupcakeServlet", value = "/ChooseCupcakeServlet")
public class ChooseCupcakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String selectedRadiobuttonValueButtom = request.getParameter("flavorpricebuttom");
        String selectedRadiobuttonValueTopping = request.getParameter("flavorpricetopping");





        request.getRequestDispatcher("WEB-INF/tags/opretbruger.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
