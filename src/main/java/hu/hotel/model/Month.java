package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public enum Month {
    JANUARY(1, 1),
    FEBRUARY(2, 32),
    MARCH(3, 60),
    APRIL(4, 91),
    MAY(5, 121),
    JUNE(6, 152),
    JULY(7, 182),
    AUGUST(8, 213),
    SEPTEMBER(9, 244),
    OCTOBER(10, 274),
    NOVEMBER(11, 305),
    DECEMBER(12, 335);

    private int monthId;
    private int dayOfYear;

    Month(int monthId, int dayOfYear) {
        this.monthId = monthId;
        this.dayOfYear = dayOfYear;
    }

    public static Month setMonth(int id) {
        Month month = null;
        for (Month thisMonth: Month.values()) {
            if (thisMonth.monthId == id) {
                month = thisMonth;
            }
        }
        return month;
    }

    public int getMonthId() {
        return monthId;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }
}
