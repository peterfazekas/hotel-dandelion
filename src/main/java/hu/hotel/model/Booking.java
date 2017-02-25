package hu.hotel.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class Booking {

    private static final int ROOM_CAPACITY = 2;

    private final int id;
    private final int room;
    private final int arrivalDay;
    private final int departureDay;
    private final int numberOfGuests;
    private final boolean breakfast;
    private final String name;
    private final Season season;

    public Booking(final int id, final int room, final int arrivalDay, final int departureDay, final int numberOfGuests,
                   final boolean breakfast, final String name) {
        this.id = id;
        this.room = room;
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.name = name;
        season = Season.setSeason(arrivalDay);
    }

    public int getId() {
        return id;
    }

    public int getRoom() {
        return room;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public String getName() {
        return name;
    }

    public Season getSeason() {
        return season;
    }

    public int getTotalPrice() {
        int roomPrice = getNumberOfNights() * season.getPrice();
        int extraBedPrice = getTruckleBed() * numberOfGuests * Price.EXTRABED.getPrice();
        int breakfastPrice = isBreakfast() ? numberOfGuests * getNumberOfNights() * Price.BREAKFAST.getPrice() : 0;
        return roomPrice + extraBedPrice + breakfastPrice;
    }

    public int getNumberOfNights() {
        return departureDay - arrivalDay;
    }

    private int getTruckleBed() {
        return numberOfGuests > ROOM_CAPACITY ? numberOfGuests - ROOM_CAPACITY : 0;
    }

    public Map<Month, Integer> getGuestNights() {
        Map<Month, Integer> guestNights = new TreeMap<>();
        for (int day = arrivalDay; day < departureDay; day++) {
            Month month = Month.setMonth(day);
            int night = 0;
            if(guestNights.containsKey(month)) {
                night = guestNights.get(month);
            }
            night += numberOfGuests ;
            guestNights.put(month, night);
        }
        return guestNights;
    }

    @Override
    public String toString() {
        return id + ":" + getTotalPrice();
    }
}
