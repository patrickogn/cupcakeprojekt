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
import java.util.List;

@WebServlet(name = "BrugersideServlet", value = "/BrugersideServlet")
public class BrugersideServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserMapper userMapper = new UserMapper(connectionPool);
        List<User> brugerliste = null;

        try {
            brugerliste = userMapper.hentAlleBrugere();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        session.setAttribute("brugerliste", brugerliste);
        request.getRequestDispatcher("WEB-INF/tags/brugerside.jsp").forward(request,response);


//Testkommentar fra Marie
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}