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


@WebServlet(name = "TransaktionServlet", value = "/TransaktionServlet")
public class TransaktionServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
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
        request.getRequestDispatcher("WEB-INF/tags/brugerliste.jsp").forward(request, response);


       /* HttpSession session = request.getSession();
        String beløb = request.getParameter("value");
        String balance = request.getParameter("balance");

        User user = (User) request.getSession().getAttribute(balance);

        int i = Integer.parseInt(beløb);
        String fejlBesked = "";

        if (i < 0) {
            fejlBesked = "du ikke indsætte et negativt beløb";

        }
        try {
            User.insert(i);
        } catch (Exception e) {

            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);

        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
