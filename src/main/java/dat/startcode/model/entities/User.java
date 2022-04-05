package dat.startcode.model.entities;

import java.util.Objects;

public class User
{
    private String email;
    private String password;
    private int roleId;
    private String firstname;
    private String lastname;
    private int balance;

    public User(String email, String password, int roleId, String firstname, String lastname, int balance)
    {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
    }



    @Override
    public String toString()
    {
        return "User{" +
                "brugerNavn='" + email + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + roleId + '\'' +
                '}';
    }

    public String getEmail()
    {
        return email;
    }

    public void setUsername(String username)
    {
        this.email = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) &&
                getRoleId() == user.getRoleId();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmail(), getPassword(), getRoleId());
    }
}
