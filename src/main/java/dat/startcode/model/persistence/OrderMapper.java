package dat.startcode.model.persistence;

import dat.startcode.model.dtos.CartDTO;
import dat.startcode.model.dtos.OrderDTO;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<Order> hentAlleOrdrer() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<Order> ordrerList = new ArrayList<>();

        String sql = "SELECT * FROM `order`";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = Integer.parseInt(rs.getString("order_id"));
                    int user_id = Integer.parseInt(rs.getString("user_id"));
                    int totalPrice = Integer.parseInt(rs.getString("total_price"));
                    Timestamp timestamp = rs.getTimestamp("timestamp");
                    int status_id = Integer.parseInt(rs.getString("status_id"));

                    Order newOrdrer = new Order(order_id, user_id, totalPrice, timestamp, status_id);
                    ordrerList.add(newOrdrer);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af ordrer fra databasen");
        }
        return ordrerList;
    }


    public OrderDTO opretNyOrder(OrderDTO orderDTO) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        boolean result = false;
        int newId = 0;
        String sql = "insert into order (order_id, user_id, total_price,timestamp,status_id) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, orderDTO.getOrder_id());
                ps.setInt(2, orderDTO.getUser_id());
                ps.setInt(3, orderDTO.getTotalPrice());
                ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                ps.setInt(5, orderDTO.getStatus_id());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                } else
                {
                    throw new DatabaseException("ordre med ordreid = " + orderDTO.getOrder_id() + " kunne ikke oprettes i databasen");
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next())
                {
                    newId = idResultset.getInt(1);
                    orderDTO.setOrder_id(newId);
                } else
                {
                    orderDTO = null;
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke indsætte ordre i databasen");
        }
        return orderDTO;
    }
}


