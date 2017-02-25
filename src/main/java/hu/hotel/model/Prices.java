package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public enum Prices {

    BREAKFAST(1100), EXTRABED(2000), AUTUMN(8000), SPRING(9000), SUMMER(10000);

    private int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
