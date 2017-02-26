package hu.hotel.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class Booking {

    private static final int ROOM_CAPACITY = 2;

    private final int id;
    private final int room;
    private final StayPeriod stayPeriod;
    private final int numberOfGuests;
    private final boolean breakfast;
    private final String name;
    private final Season season;

    public Booking(final int id, final int room, final StayPeriod stayPeriod, final int numberOfGuests,
        final boolean breakfast, final String name) {
        this.id = id;
        this.room = room;
        this.stayPeriod = stayPeriod;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.name = name;
        season = Season.setSeason(stayPeriod.getArrivalDay());
    }

    public int getId() {
        return id;
    }

    public int getRoom() {
        return room;
    }

    public int getArrivalDay() {
        return stayPeriod.getArrivalDay();
    }

    public int getDepartureDay() {
        return stayPeriod.getDepartureDay();
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
        int roomPrice = getNumberOfNights() * getSeason().getPrice();
        int extraBedPrice = getTruckleBed() * getNumberOfGuests() * Price.EXTRABED.getPrice();
        int breakfastPrice = isBreakfast() ? getNumberOfGuests() * getNumberOfNights() * Price.BREAKFAST.getPrice() : 0;
        return roomPrice + extraBedPrice + breakfastPrice;
    }

    public int getNumberOfNights() {
        return getDepartureDay() - getArrivalDay();
    }

    private int getTruckleBed() {
        return numberOfGuests > ROOM_CAPACITY ? numberOfGuests - ROOM_CAPACITY : 0;
    }

    public Map<Month, Integer> getGuestNights() {
        Map<Month, Integer> guestNights = new TreeMap<>();
        for (int day = getArrivalDay(); day < getDepartureDay(); day++) {
            Month month = Month.setMonth(day);
            int night = guestNights.containsKey(month) ? guestNights.get(month) : 0;
            night += numberOfGuests ;
            guestNights.put(month, night);
        }
        return guestNights;
    }

    public boolean isRoomOccupiedOnCertainDay(int day) {
        return (day >= getArrivalDay() && day < getDepartureDay());
    }

    @Override
    public String toString() {
        return id + ":" + getTotalPrice();
    }
}
