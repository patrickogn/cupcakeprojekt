package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OrderLineServlet", value = "/OrderLineServlet")
public class OrderLineServlet extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int buttom_id = Integer.parseInt(request.getParameter("buttom_id"));
        int topping_id = Integer.parseInt(request.getParameter("topping_id"));

        OrderLine orderline = new OrderLine(order_id, quantity, buttom_id,topping_id);
        UserMapper userMapper = new UserMapper(connectionPool);
        try
        {
            OrderLine nyOrderLine = userMapper.nyOrderLine(orderline);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("bogliste").forward(request, response);
    }


}
