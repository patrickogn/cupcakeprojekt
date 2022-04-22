package dat.startcode.model.entities;

import java.util.Objects;

public class OrderLine
{

    private int order_id;
    private int quantity;
    private int buttom_id;
    private int topping_id;

    public OrderLine(int order_id, int quantity, int buttom_id, int topping_id)
    {
        this.order_id = order_id;
        this.quantity = quantity;
        this.buttom_id = buttom_id;
        this.topping_id = topping_id;
    }

    public int getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getButtom_id()
    {
        return buttom_id;
    }

    public void setButtom_id(int buttom_id)
    {
        this.buttom_id = buttom_id;
    }

    public int getTopping_id()
    {
        return topping_id;
    }

    public void setTopping_id(int topping_id)
    {
        this.topping_id = topping_id;
    }

    @Override
    public String toString()
    {
        return "OrderLine{" +
                "order_id=" + order_id +
                ", quantity=" + quantity +
                ", buttom_id=" + buttom_id +
                ", topping_id=" + topping_id +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return order_id == orderLine.order_id && quantity == orderLine.quantity && buttom_id == orderLine.buttom_id && topping_id == orderLine.topping_id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(order_id, quantity, buttom_id, topping_id);
    }
}

