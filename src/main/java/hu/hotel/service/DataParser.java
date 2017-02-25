package hu.hotel.service;

import hu.hotel.model.Booking;
import hu.hotel.model.StayPeriod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class DataParser {

    private static final String SEPARATOR = " ";

    public BookingService parse(List<String> lines) {
        return new BookingService(parseText(lines));
    }

    private List<Booking> parseText(List<String> lines) {
        List<Booking> bookings = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            bookings.add(parseLine(line));
        }
        return bookings;
    }

    private Booking parseLine(String line) {
        String[] data = line.split(SEPARATOR);
        int id = Integer.parseInt(data[0]);
        int room =  Integer.parseInt(data[1]);
        int arrival =  Integer.parseInt(data[2]);
        int departure =  Integer.parseInt(data[3]);
        int numberOfGuests =  Integer.parseInt(data[4]);
        boolean breakfast =  Integer.parseInt(data[5]) == 1;
        String name = data[6];
        StayPeriod stayPeriod = new StayPeriod(arrival, departure);
        return new Booking(id, room, stayPeriod, numberOfGuests, breakfast, name);
    }

    public StayPeriod getStayPeriod(Console console) {
        String line = console.readLine();
        String[] data = line.split(SEPARATOR);
        int arrival = Integer.parseInt(data[0]);
        int numberOfNights = Integer.parseInt(data[1]);
        return new StayPeriod(arrival, arrival + numberOfNights);
    }
}
