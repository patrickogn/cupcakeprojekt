package dat.startcode.model.persistence;

import dat.startcode.model.entities.Cupcaketopping;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupcakeToppingMapper implements ICupcakeToppingMapper {

    private ConnectionPool connectionPool;

    public CupcakeToppingMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Cupcaketopping> getCupcakeToppingData() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<Cupcaketopping> cupcaketoppingList = new ArrayList<>();

        //String sql = "SELECT cupcaketopping.topping_id, cupcaketopping.flavor, cupcaketopping.price";
        String sql = "SELECT * FROM cupcaketopping";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int topping_id = rs.getInt("topping_id");
                    String flavor = rs.getString("flavor");
                    int price = rs.getInt("price");
                    String topping_picture_id = rs.getString("topping_picture_id");

                    Cupcaketopping cupcaketopping = new Cupcaketopping(topping_id, flavor, price, topping_picture_id);
                    cupcaketoppingList.add(cupcaketopping);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning af cupcakebunde fra databasen");
        }
        return cupcaketoppingList;
    }
}

