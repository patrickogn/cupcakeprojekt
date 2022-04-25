package dat.startcode.model.persistence;

import dat.startcode.model.dtos.OrderDTO;
import dat.startcode.model.entities.Order;
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

    @Override
    public List<User> hentAlleLaanere() throws DatabaseException {
        return null;
    }

    public List<User> hentAlleBrugere() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<User> brugerlist = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int user_id = Integer.parseInt(rs.getString("user_id"));
                    String roleIdString = rs.getString("role_id");
                    String password = rs.getString("password");
                    int roleId = Integer.parseInt(roleIdString);
                    String firstname = rs.getString("firstname");
                    String surname = rs.getString("lastname");
                    int balance = Integer.parseInt(rs.getString("balance"));
                    int phone_no = Integer.parseInt(rs.getString("phone_no"));
                    String email = rs.getString("email");

                    User newuser = new User(user_id, password, roleId, firstname, surname, balance, phone_no, email);
                    brugerlist.add(newuser);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af lånere fra databasen");
        }
        return brugerlist;
    }


    //Metode kan opdatere brugers informationer - herunder saldo --> US-3
    public boolean opdaterBruger(User user) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "UPDATE user SET password = ?, role_id = ?, firstname = ?, lastname = ?, balance = ?, phone_no = ?, email = ? " +
                "WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getPassword());
                ps.setInt(2, user.getRole_id());
                ps.setString(3, user.getFirstname());
                ps.setString(4, user.getLastname());
                ps.setInt(5, user.getBalance());
                ps.setInt(6, user.getPhone_no());
                ps.setString(7, user.getEmail());
                ps.setInt(8, user.getUser_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1){
                    result = true;
                } else {
                    throw new DatabaseException("Kunne ikke opdatere bruger med bruger_id = " + user.getUser_id());
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Kunne ikke opdatere bruger med bruger_id = " + user.getUser_id());
        }
        return result;
    }


    public User HentBrugerFraId(int brugerId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "Brugerid=" + brugerId);
        User user = null;
        String sql = "select * FROM user where user_id = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, brugerId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    brugerId = rs.getInt("user_id");
                    String password = rs.getString("password");
                    String roleIdString = rs.getString("role_id");
                    int roleId = Integer.parseInt(roleIdString);
                    String firstname = rs.getString("firstname");
                    String surname = rs.getString("lastname");
                    int balance = Integer.parseInt(rs.getString("balance"));
                    int phone_no = Integer.parseInt(rs.getString("phone_no"));
                    String email = rs.getString("email");

                    user = new User(brugerId, password, roleId, firstname, surname, balance, phone_no, email);
                } else
                {
                    throw new DatabaseException("Låner med brugerid = " + brugerId + " findes ikke");
                }
            }
        } catch (SQLException | DatabaseException ex)
        {
            throw new DatabaseException(ex, "Fejl i databaseforespørgsel for brugerid = " + brugerId);
        }
        return user;
    }


   // US-6: Som administrator kan jeg se alle ordrer i systemet, så jeg kan se hvad der er blevet bestilt.

    public List<Order> hentAlleOrdrer() throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        List<Order> ordrerList = new ArrayList<>();

       String sql = "SELECT * FROM `cupcakemmp`.`order`";


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
}
