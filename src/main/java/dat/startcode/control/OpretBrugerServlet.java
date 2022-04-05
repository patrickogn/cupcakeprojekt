package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OpretBrugerServlet", value = "/OpretBrugerServlet")
public class OpretBrugerServlet extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("psw");

        int roleId = 2;

        String rpPassword = request.getParameter("psw-repeat");

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("surname");
        String balance = request.getParameter("balance");
        int balanceInt = Integer.parseInt(balance);

        String user_id = "0";
        int user_idInt = Integer.parseInt(user_id);
        String phone_no = "11111111";
        int phone_noInt = Integer.parseInt(phone_no);


//        UserMapper userMapper = new UserMapper(connectionPool);
//        try {
//            userMapper.createUser(email, password, roleId, firstname, surname, balance);
        //TODO: vil gerne bruge createUser-metoden, men kan ikke få det til at virke
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }

        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String role_id = "" + roleId;
        //String sql = "insert into user (email, password, roleIdString, firstname, surname, balanceString) values (?,?,?,?,?,?)";
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


//                ps.setString(1, email);
//                ps.setString(2, password);
//                ps.setString(3, roleIdString);
//                ps.setString(4, firstname);
//                ps.setString(5, surname);
//                ps.setString(6, balanceString);


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
        catch (SQLException | DatabaseException ex)
        {
            try {
                throw new DatabaseException(ex, "Could not insert email into database");
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

        //User user = new User(email, password, roleId, firstname, surname, balance);

       // request.getRequestDispatcher("WEB-INF/tags/opretbruger.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
