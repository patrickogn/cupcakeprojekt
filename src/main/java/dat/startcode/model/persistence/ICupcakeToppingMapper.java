package dat.startcode.model.persistence;

import dat.startcode.model.entities.Cupcaketopping;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.List;

public interface ICupcakeToppingMapper {


    // Find alle bøger, og deres forfattere
    public List<Cupcaketopping> getCupcakeToppingData()  throws DatabaseException;


}
