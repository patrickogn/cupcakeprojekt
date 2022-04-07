package dat.startcode.model.dtos;

import dat.startcode.model.entities.Cupcakebuttom;
import dat.startcode.model.entities.Cupcaketopping;

public class CartDTO {
    private Cupcakebuttom buttom;
    private Cupcaketopping topping;
    private int quantity;

    public CartDTO(Cupcakebuttom buttom, Cupcaketopping topping, int quantity) {
        this.buttom = buttom;
        this.topping = topping;
        this.quantity = quantity;
    }

    public int getPrice(){
        return (topping.getPrice() + buttom.getPrice()) * quantity;
    }

    public Cupcaketopping getTopping() {
        return topping;
    }

    public Cupcakebuttom getButtom() {
        return buttom;
    }

    public int getQuantity() {
        return quantity;
    }
}
