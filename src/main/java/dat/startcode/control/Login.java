package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.UserMapper;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "login", urlPatterns = {"/login"} )
public class Login extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        doPost(request, response);
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // adding empty user object to session scope
        UserMapper userMapper = new UserMapper(connectionPool);
        User user = null;
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        //indsat balance
        String balance = request.getParameter("balance");

        //indsat firstname
        String firstname = request.getParameter("firstname");

        //indsat lastname/efternavn
        String lastname = request.getParameter("lastname");




        try
        {
            user = userMapper.login(email, password);
            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope
            session.setAttribute("balance", balance); //setter attribute balance
            session.setAttribute("firstname", firstname); //setter attribute fornavn
            session.setAttribute("lastname", lastname); //setter attribute efternavn

            //Indlæser listen over alle brugere
            List<User> brugerliste = null;

            try {
                brugerliste = userMapper.hentAlleBrugere();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            session.setAttribute("brugerliste", brugerliste);


            request.getRequestDispatcher("WEB-INF/tags/brugerside.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    public void destroy()
    {

    }
}