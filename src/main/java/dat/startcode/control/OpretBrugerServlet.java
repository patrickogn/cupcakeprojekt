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
        String surname = request.getParameter("surname");
        String balanceString = request.getParameter("balance");
        int balance = Integer.parseInt(balanceString);

//        UserMapper userMapper = null;
//        try {
//            userMapper.createUser(email, password, roleId, firstname, surname, balance);
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }

        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String roleIdString = "" + roleId;
        String sql = "insert into user (email, password, roleIdString, firstname, surname, balanceString) values (?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, roleIdString);
                ps.setString(4, firstname);
                ps.setString(5, surname);
                ps.setString(6, balanceString);


                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(email, password, roleId, firstname, surname, balance);
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

        //User user = new User(email, password, roleId, firstname, surname, balance);

       // request.getRequestDispatcher("WEB-INF/tags/opretbruger.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
