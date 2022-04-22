package dat.startcode.model.persistence;

import dat.startcode.model.dtos.OrderDTO;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper
{

    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }
//    @Override
//    public User login(String email, String password) throws DatabaseException
//    {
//        Logger.getLogger("web").log(Level.INFO, "");
//
//        User user = null;
//
//        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
//
//        try (Connection connection = connectionPool.getConnection())
//        {
//            try (PreparedStatement ps = connection.prepareStatement(sql))
//            {
//                ps.setString(1, email);
//                ps.setString(2, password);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next())
//                {
//                    String role = rs.getString("role_id");
//                    user = new User(email, password, role);
//                } else
//                {
//                    throw new DatabaseException("Wrong email or password");
//                }
//            }
//        } catch (SQLException ex)
//        {
//            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
//        }
//        return user;
//    }

    @Override
    public User login(String email, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int user_id = Integer.parseInt(rs.getString("user_id"));
                    String roleIdString = rs.getString("role_id");
                    int roleId = Integer.parseInt(roleIdString);
                    String firstname = rs.getString("firstname");
                    String surname = rs.getString("lastname");
                    int balance = Integer.parseInt(rs.getString("balance"));
                    int phone_no = Integer.parseInt(rs.getString("phone_no"));

                    user = new User(user_id, password, roleId, firstname, surname, balance, phone_no, email);
                } else
                {
                    throw new DatabaseException("Wrong email or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String email, String password, int roleId, String firstname, String lastname, int balanceInt) throws DatabaseException
    {

        String user_id = "0";
        int user_idInt = Integer.parseInt(user_id);
        String phone_no = "12345678";
        int phone_noInt = Integer.parseInt(phone_no);
        String balance = "" + balanceInt;
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String role_id = "" + roleId;
        //String sql = "insert into user (email, password, roleIdString) values (?,?,?)";
        String sql = "insert into user (user_id, password, role_id, firstname, lastname, balance, phone_no, email) values (?,?,?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, user_id);
                ps.setString(2, password);
                ps.setString(3, role_id);
                ps.setString(4, firstname);
                ps.setString(5, lastname);
                ps.setString(6, balance);
                ps.setString(7, phone_no);
                ps.setString(8, email);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(user_idInt, password, roleId, firstname, lastname, balanceInt, phone_noInt, email);
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert email into database");
        }
        return user;
    }


   // US-6: Som administrator kan jeg se alle ordrer i systemet, så jeg kan se hvad der er blevet bestilt.


    public List<Order> hentAlleOrdrer() throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        List<Order> ordrerList = new ArrayList<>();

       String sql = "SELECT * FROM `order`";


        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int order_id = Integer.parseInt(rs.getString("order_id"));
                    int user_id = Integer.parseInt(rs.getString("user_id"));
                    int totalPrice = Integer.parseInt(rs.getString("total_price"));
                    Timestamp timestamp = rs.getTimestamp("timestamp");
                    int status_id = Integer.parseInt(rs.getString("status_id"));

                    Order newOrdrer = new Order(order_id, user_id, totalPrice, timestamp, status_id);
                    ordrerList.add(newOrdrer);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning af ordrer fra databasen");
        }
        return ordrerList;
    }

    //opret orderline
//    public OrderLine opretOrderLine(OrderLine orderLine ) throws DatabaseException
//    {
//        Logger.getLogger("web").log(Level.INFO, "");
//        OrderLine orderline;
//        String sql = "insert into orderline (order_id, quantity, buttom_id,topping_id) values (?,?,?,?)";
//        try (Connection connection = connectionPool.getConnection())
//        {
//            try (PreparedStatement ps = connection.prepareStatement(sql))
//            {
//                ps.setInt(1, order_id);
//                ps.setInt(2, quantity);
//                ps.setInt(3, buttom_id);
//                ps.setInt(4, topping_id);
//                int rowsAffected = ps.executeUpdate();
//                if (rowsAffected == 1)
//                {
//                    orderline = new OrderLine(order_id, quantity, buttom_id,topping_id);
//                } else
//                {
//                    throw new DatabaseException("Ordren med order_id = " + order_id + " kunne ikke oprettes i databasen");
//                }
//            }
//        }
//        catch (SQLException ex)
//        {
//            throw new DatabaseException(ex, "Kunne ikke indsætte order i databasen");
//        }
//        return orderline;
//    }

    public OrderLine nyOrderLine(OrderLine orderLine) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        int newId = 0;
        String sql = "insert into orderline (order_id, quantity, buttom_id, topping_id) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, orderLine.getOrder_id());
                ps.setInt(2, orderLine.getQuantity());
                ps.setInt(3, orderLine.getButtom_id());
                ps.setInt(3, orderLine.getTopping_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                } else
                {
                    throw new DatabaseException("Order med = " + orderLine.getOrder_id() + " kunne ikke oprettes i databasen");
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next())
                {
                    newId = idResultset.getInt(1);
                    orderLine.setOrder_id(newId);
                } else
                {
                    orderLine = null;
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke indsætte orderLine i databasen");
        }
        return orderLine;
    }


}
