package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.dtos.CartDTO;
import dat.startcode.model.entities.Cupcakebuttom;
import dat.startcode.model.entities.Cupcaketopping;
import dat.startcode.model.entities.User;
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

        CupcakeButtomMapperHashmap cupcakeButtomMapperHashmap = new CupcakeButtomMapperHashmap(connectionPool);
        CupcakeToppingMapperHashmap cupcakeToppingMapperHashmap = new CupcakeToppingMapperHashmap(connectionPool);
        try {

            String selectedRadiobuttonValueButtom = request.getParameter("flavorpricebuttom");
            Integer selectedButtomId = Integer.parseInt(selectedRadiobuttonValueButtom);

            String selectedRadiobuttonValueTopping = request.getParameter("flavorpricetopping");
            Integer selectedToppingId = Integer.parseInt(selectedRadiobuttonValueTopping);

            String antal = request.getParameter("quantity");
            Integer antalint = Integer.parseInt(antal);

            cartDTOList.add(new CartDTO(cupcakeButtomMapperHashmap.getCupcakeButtomObjectMap().get(selectedButtomId), cupcakeToppingMapperHashmap.getCupcakeToppingObjectMap().get(selectedToppingId), antalint));

            String samletpris = request.getParameter("samletpris");
            System.out.println(samletpris);

            session.setAttribute("cartDTOList", cartDTOList);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }



        //TODO: skal hente priserne fra databasen

        request.getRequestDispatcher("").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
