package dat.startcode.model.entities;

public class ChosenCupcake {
    private String buttom;
    private String topping;
    private int cupcakePrice;
    private int buttomPrice;
    private int toppingPrice;


    public ChosenCupcake(String buttom, String topping, int buttomPrice, int toppingPrice) {
        this.buttom = buttom;
        this.topping = topping;
        this.cupcakePrice = buttomPrice + toppingPrice;
    }

    public String getButtom() {
        return buttom;
    }

    public void setButtom(String buttom) {
        this.buttom = buttom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getCupcakePrice() {
        return cupcakePrice;
    }

    public void setCupcakePrice(int cupcakePrice) {
        this.cupcakePrice = cupcakePrice;
    }

    public int getButtomPrice() {
        return buttomPrice;
    }

    public void setButtomPrice(int buttomPrice) {
        this.buttomPrice = buttomPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String toString() {
        return "Cupcake: " +
                "bund " + buttom +
                ", topping " + topping +
                ", pris " + cupcakePrice + " kr";
    }
}
