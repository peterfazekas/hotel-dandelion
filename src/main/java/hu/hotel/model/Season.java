package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public enum Season {
    SPRING(Month.JANUARY, Prices.SPRING), SUMMER(Month.MAY, Prices.SUMMER), AUTUMN(Month.SEPTEMBER, Prices.AUTUMN);

    private Month month;
    private Prices price;

    Season(Month month, Prices price) {
        this.month = month;
        this.price = price;
    }

    public static Season setSeason(int countOfDay) {
        Season season = null;
        return season;
    }

    public int getPrice() {
        return price.getPrice();
    }
}
