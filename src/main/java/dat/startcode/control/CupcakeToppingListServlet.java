package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Cupcaketopping;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeToppingMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CupcakeToppingListServlet", value = "/CupcakeToppingListServlet")
public class CupcakeToppingListServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CupcakeToppingMapper cupcakeToppingMapper = new CupcakeToppingMapper(connectionPool);
        List<Cupcaketopping> cupcaketoppingList = null;
        try
        {
            cupcaketoppingList = cupcakeToppingMapper.getCupcakeToppingData();
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("cupcaketoppinglist", cupcaketoppingList);
        request.getRequestDispatcher("WEB-INF/cupcakes.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
