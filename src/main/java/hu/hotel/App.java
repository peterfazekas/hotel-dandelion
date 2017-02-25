package hu.hotel;

import hu.hotel.data.read.DataFileReader;
import hu.hotel.data.read.DataReader;
import hu.hotel.data.write.DataFileLogger;
import hu.hotel.data.write.DataLogger;
import hu.hotel.service.BookingService;
import hu.hotel.service.DataParser;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class App {

    private final DataReader file;
    private final DataLogger log;
    private final DataParser data;
    private final BookingService bookingService;

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    public App() {
        file = new DataFileReader("pitypang.txt");
        log = new DataFileLogger("bevetel.txt");
        data = new DataParser();
        bookingService = data.parse(file.read());
    }

    private void println() {
        System.out.println("2. feladat: a leghosszabb szállodai tartózkodás: " + bookingService.getLongestStay());
        bookingService.getTotalPrices(log);
        System.out.println("4. feladat: " + bookingService.getTotalGuestNights());
    }
}
