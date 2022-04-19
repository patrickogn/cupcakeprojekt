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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RedigerBrugerServlet", value = "/RedigerBrugerServlet")
public class RedigerBrugerServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idString = request.getParameter("rediger");
        int brugerId = Integer.parseInt(idString);
        User bruger = null;
        UserMapper userMapper = new UserMapper(connectionPool);
        try
        {
            bruger = userMapper.HentBrugerFraId(brugerId);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("user", bruger);
        request.getRequestDispatcher("WEB-INF/tags/redigerbruger.jsp").forward(request, response);
    }
}
