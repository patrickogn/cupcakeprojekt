package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.List;

public interface IUserMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public User createUser(String email, String password, int roleId, String firstname, String surname, int balance) throws DatabaseException;
    List<User> hentAlleLaanere() throws DatabaseException;
}
