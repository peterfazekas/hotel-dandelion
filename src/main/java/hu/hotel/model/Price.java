package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public enum Price {

    BREAKFAST(1100), EXTRABED(2000), AUTUMN(8000), SPRING(9000), SUMMER(10000);

    private final int price;

    Price(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
