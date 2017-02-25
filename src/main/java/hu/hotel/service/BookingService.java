package hu.hotel.service;

import hu.hotel.data.write.DataLogger;
import hu.hotel.model.Booking;

import java.util.Comparator;
import java.util.List;

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
}
