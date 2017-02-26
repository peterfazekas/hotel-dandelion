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

    private static final String NEWLINE = "\r\n";
    private static final int MAXROOM = 27;

    private final List<Booking> bookings;

    public BookingService(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getLongestStay() {
        Booking longestBooking = bookings.stream()
                .max(Comparator.comparing(booking -> booking.getNumberOfNights()))
                .get();
        return longestBooking.getName() + " (" + longestBooking.getArrivalDay() + ") - " + longestBooking.getNumberOfNights();
    }

    public String getTotalPrices() {
        StringBuilder sb = new StringBuilder();
        bookings.forEach(booking -> sb.append(booking.getId() + ":" + booking.getTotalPrice() + NEWLINE));
        return sb.toString();
    }

    public String getTotalGuestNights() {
        StringBuilder sb = new StringBuilder();
        Map<Month, Integer> totalGuestNights = calculateTotalGuestNights();
        for (Map.Entry<Month, Integer> guestNights : totalGuestNights.entrySet()) {
            int month = guestNights.getKey().getMonthId();
            int guestNight = guestNights.getValue();
            sb.append(NEWLINE + month + ": " + guestNight + " vendégéj");
        }
        return sb.toString();
    }

    private Map<Month, Integer> calculateTotalGuestNights() {
        Map<Month, Integer> totalGuestNights = new IntegerValueMap<>();
        for (Booking booking : bookings) {
            Map<Month, Integer> guestNights = booking.getGuestNights();
            totalGuestNights.putAll(guestNights);
        }
        return totalGuestNights;
    }

    public String getFreeRooms(StayPeriod stayPeriod) {
        boolean[] rooms = searchFreeRooms(stayPeriod);
        int counter = 0;
        for (int room = 0; room < rooms.length; room++) {
            if(!rooms[room]) {
                counter++;
            }
        }
        return "A megadott időintervallumban " + counter + " szabad szoba áll rendelkezésre!";
    }

    private boolean[] searchFreeRooms(StayPeriod stayPeriod) {
        boolean[] rooms = new boolean[MAXROOM];
        for (int day = stayPeriod.getArrivalDay(); day <= stayPeriod.getDepartureDay() ; day++) {
            for (Booking booking : bookings) {
                if(booking.isRoomOccupiedOnCertainDay(day)) {
                    int room = booking.getRoom();
                    rooms[room - 1] = true;
                }
            }
        }
        return rooms;
    }
}
