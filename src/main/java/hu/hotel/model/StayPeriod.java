package hu.hotel.model;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class StayPeriod {

    private final int arrivalDay;
    private final int departureDay;

    public StayPeriod(int arrivalDay, int departureDay) {
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public int getDepartureDay() {
        return departureDay;
    }
}
