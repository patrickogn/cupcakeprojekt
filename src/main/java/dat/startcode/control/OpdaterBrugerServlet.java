package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OpdaterBrugerServlet", value = "/OpdaterBrugerServlet")
public class OpdaterBrugerServlet extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idString = request.getParameter("id");
        int brugerid = Integer.parseInt(idString);
        String password = request.getParameter("kodeord");

        String roleidstring = request.getParameter("roleid");
        int roleid = Integer.parseInt(roleidstring);

        String firstname = request.getParameter("fornavn");
        String surname = request.getParameter("efternavn");
        //idString = String.valueOf(Integer.parseInt(idString));

        String phone_no = request.getParameter("telefonnummer");
        int phonenumber = Integer.parseInt(phone_no);

        String balancestring = request.getParameter("saldo");
        int balance = Integer.parseInt(balancestring);

        String email = request.getParameter("email");

        User user = new User(brugerid,password,roleid,firstname,surname,balance,phonenumber,email);
        UserMapper userMapper = new UserMapper(connectionPool);
        try
        {
            boolean result = userMapper.opdaterBruger(user);
        } catch (DatabaseException e) {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/tags/brugerliste.jsp").forward(request, response);
    }
}
