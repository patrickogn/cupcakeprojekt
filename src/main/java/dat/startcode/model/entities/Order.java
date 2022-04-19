package dat.startcode.model.entities;
import java.sql.Timestamp;

public class Order
{
    private int order_id;
    private int user_id;
    private int totalPrice;
    private Timestamp timestamp;
    private int status_id;

    public Order(int order_id, int user_id, int totalPrice, Timestamp timestamp, int status_id)
    {
        this.order_id = order_id;
        this.user_id = user_id;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
        this.status_id = status_id;
    }

    public int getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public int getStatus_id()
    {
        return status_id;
    }

    public void setStatus_id(int status_id)
    {
        this.status_id = status_id;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", totalPrice=" + totalPrice +
                ", timestamp=" + timestamp +
                ", status_id=" + status_id +
                '}';
    }
}


