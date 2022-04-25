package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.dtos.OrderDTO;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OpretOrdreServlet", urlPatterns = {"/OpretOrdreServlet"})
public class OpretOrdreServlet extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int orderid = 0;
        session.getAttribute("user");

        //int user_idInt = Integer.parseInt(request.getParameter("userid"));
        int user_idInt = 1;


        int totalpriceint = 0;

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        OrderDTO orderDTO = new OrderDTO(orderid, user_idInt, totalpriceint, timestamp, 1);
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        try
        {
            OrderDTO nyorderDTO = orderMapper.opretNyOrder(orderDTO);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/cupcakes.jsp").forward(request, response);
    }

        /*String order_id = "0";
        int user_idInt = Integer.parseInt(order_id);
        String user_id = request.getParameter("userid1");
        String totalPrice = request.getParameter("samletpris1");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        String sql = "insert into order (int order_id, int user_id, int totalPrice, Timestamp timestamp, int status_id) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, order_id);
                ps.setString(2, user_id);
                ps.setString(3, totalPrice);
                ps.setTimestamp(4, timestamp);
                ps.setInt(5, 1);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    OrderDTO orderDTO = OrderMapper.
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException | DatabaseException ex)
        {
            try {
                throw new DatabaseException(ex, "Could not insert email into database");
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }*/



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/tags/opretordre.jsp").forward(request, response);
    }
}
