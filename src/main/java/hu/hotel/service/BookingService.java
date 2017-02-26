package hu.hotel.service;

import hu.hotel.model.Booking;
import hu.hotel.model.Month;
import hu.hotel.model.IntegerValueMap;
import hu.hotel.model.StayPeriod;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class BookingService {

    private static final String NEW_LINE = "\r\n";
    private static final int MAXIMUM_NUMBER_OF_ROOMS = 27;

    private final List<Booking> bookings;
    private boolean[] rooms = new boolean[MAXIMUM_NUMBER_OF_ROOMS];

    public BookingService(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getLongestStay() {
        Booking longestStay = bookings.stream()
                .max(Comparator.comparing(booking -> booking.getNumberOfNights()))
                .get();
        return String.format("%s (%d) - %d", longestStay.getName(), longestStay.getArrivalDay(), longestStay.getNumberOfNights());
    }

    public String getTotalPrices() {
        StringBuilder sb = new StringBuilder();
        bookings.forEach(i -> sb.append(String.format("%d:%d%s", i.getId(), i.getTotalPrice(), NEW_LINE)));
        return sb.toString();
    }

    public String getTotalGuestNights() {
        StringBuilder sb = new StringBuilder();
        Map<Month, Integer> totalGuestNights = calculateTotalGuestNights();
        totalGuestNights.entrySet()
                .forEach(i -> sb.append(String.format("%s%d: %d vendégéj", NEW_LINE, i.getKey().getMonthId(), i.getValue())));
        return sb.toString();
    }

    private Map<Month, Integer> calculateTotalGuestNights() {
        Map<Month, Integer> totalGuestNights = new IntegerValueMap<>();
        bookings.forEach(i -> totalGuestNights.putAll(i.getGuestNights()));
        return totalGuestNights;
    }

    public String getFreeRooms(final StayPeriod stayPeriod) {
        searchFreeRooms(stayPeriod);
        int counter = 0;
        for (boolean room : rooms) {
            if (!room) counter++;
        }
        return String.format("A megadott időintervallumban %d szabad szoba áll rendelkezésre!", counter);
    }

    private void searchFreeRooms(StayPeriod stayPeriod) {
        for (int day = stayPeriod.getArrivalDay(); day <= stayPeriod.getDepartureDay(); day++) {
            setFreeRooms(day);
        }
    }

    private void setFreeRooms(final int day) {
        bookings.stream()
                .filter(i -> i.isRoomOccupiedOnCertainDay(day))
                .map(i -> rooms[i.getRoom() - 1] = true);
    }
}
