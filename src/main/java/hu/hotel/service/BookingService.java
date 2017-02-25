package hu.hotel.service;

import hu.hotel.data.write.DataLogger;
import hu.hotel.model.Booking;
import hu.hotel.model.Month;
import hu.hotel.model.MyMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class BookingService {

    private static final String NEWLINE = "\r\n";

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

    public void getTotalPrices(DataLogger file) {
        bookings.forEach(booking -> file.println(booking.getId() + ":" + booking.getTotalPrice()));
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
        Map<Month, Integer> totalGuestNights = new MyMap<Month, Integer>();
        for (Booking booking : bookings) {
            Map<Month, Integer> guestNights = booking.getGuestNights();
            totalGuestNights.putAll(guestNights);
        }
        return totalGuestNights;
    }
}
