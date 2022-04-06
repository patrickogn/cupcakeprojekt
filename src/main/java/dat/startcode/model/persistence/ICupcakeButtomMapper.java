package dat.startcode.model.persistence;

import dat.startcode.model.entities.Cupcakebuttom;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.List;

public interface ICupcakeButtomMapper {


    // Find alle bøger, og deres forfattere
    public List<Cupcakebuttom> getCupcakeButtomData()  throws DatabaseException;


}
