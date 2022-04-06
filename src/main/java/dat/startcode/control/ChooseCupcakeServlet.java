package dat.startcode.control;

import dat.startcode.model.entities.ChosenCupcake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChooseCupcakeServlet", value = "/ChooseCupcakeServlet")
public class ChooseCupcakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String selectedRadiobuttonValueButtom = request.getParameter("flavorpricebuttom");
        String selectedRadiobuttonValueTopping = request.getParameter("flavorpricetopping");

        ChosenCupcake chosenCupcake = new ChosenCupcake(selectedRadiobuttonValueButtom, selectedRadiobuttonValueTopping, 5, 5);
        //TODO: skal hente priserne fra databasen

        List<ChosenCupcake> chosenCupcakeList = new ArrayList<>();
        chosenCupcakeList.add(chosenCupcake);

        request.setAttribute("chosencupcakelist", chosenCupcakeList);

        request.getRequestDispatcher("WEB-INF/chosencupcaketemp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
