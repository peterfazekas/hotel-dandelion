package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public enum Season {
    SPRING(Month.JANUARY, Price.SPRING), SUMMER(Month.MAY, Price.SUMMER), AUTUMN(Month.SEPTEMBER, Price.AUTUMN);

    private Month month;
    private Price price;

    Season(Month month, Price price) {
        this.month = month;
        this.price = price;
    }

    public static Season setSeason(int countOfDay) {
        Season season = SPRING;
        for (Season thisSeason : Season.values()) {
            if(countOfDay >= thisSeason.month.getDayOfYear())
                season = thisSeason;
        }
        return season;
    }

    public int getPrice() {
        return price.getPrice();
    }
}
