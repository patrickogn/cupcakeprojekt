package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.dtos.CartDTO;
import dat.startcode.model.entities.Cupcakebuttom;
import dat.startcode.model.entities.Cupcaketopping;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChooseCupcakeServlet", value = "/ChooseCupcakeServlet")
public class ChooseCupcakeServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartDTO> cartDTOList = (List<CartDTO>) session.getAttribute("cartDTOList");
        if (cartDTOList == null) {
            cartDTOList = new ArrayList<>();
        }
//        CupcakeButtomMapper cupcakeButtomMapper = new CupcakeButtomMapper(connectionPool);
//        CupcakeToppingMapper cupcakeToppingMapper = new CupcakeToppingMapper(connectionPool);
        CupcakeButtomMapperHashmap cupcakeButtomMapperHashmap = new CupcakeButtomMapperHashmap(connectionPool);
        CupcakeToppingMapperHashmap cupcakeToppingMapperHashmap = new CupcakeToppingMapperHashmap(connectionPool);
        try {
//            List<Cupcakebuttom> cupcakebuttomList = cupcakeButtomMapper.getCupcakeButtomData();
//            List<Cupcaketopping> cupcaketoppingList = cupcakeToppingMapper.getCupcakeToppingData();
//            String selectedRadiobuttonValueButtom = request.getParameter("flavorpricebuttom");
//            String selectedRadiobuttonValueTopping = request.getParameter("flavorpricetopping");
            String selectedRadiobuttonValueButtom = request.getParameter("flavorpricebuttom");
            Integer selectedButtomId = Integer.parseInt(selectedRadiobuttonValueButtom);
            String selectedRadiobuttonValueTopping = request.getParameter("flavorpricetopping");
            Integer selectedToppingId = Integer.parseInt(selectedRadiobuttonValueTopping);
            //Cupcaketopping cupcaketopping = cupcaketoppingList.

            //cartDTOList.add(new CartDTO(new Cupcaketopping("jorbær", ), new Cupcakebuttom("")), 1);
            //cartDTOList.add(new CartDTO(selectedRadiobuttonValueButtom, selectedRadiobuttonValueTopping), 1);

            cartDTOList.add(new CartDTO(cupcakeButtomMapperHashmap.getCupcakeButtomObjectMap().get(selectedButtomId), cupcakeToppingMapperHashmap.getCupcakeToppingObjectMap().get(selectedToppingId), 1));
            //TODO: quantity skal hentes fra userinput
            session.setAttribute("cartDTOList", cartDTOList);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        //ChosenCupcake chosenCupcake = new ChosenCupcake(selectedRadiobuttonValueButtom, selectedRadiobuttonValueTopping, 5, 5);
        //TODO: skal hente priserne fra databasen

//        List<ChosenCupcake> chosenCupcakeList = new ArrayList<>();
//        chosenCupcakeList.add(chosenCupcake);
//
//        request.setAttribute("chosencupcakelist", chosenCupcakeList);

        // request.getRequestDispatcher("WEB-INF/chosencupcaketemp.jsp").forward(request, response);
        // request.getRequestDispatcher("WEB-INF/cupcakes.jsp").forward(request, response);
        request.getRequestDispatcher("").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
