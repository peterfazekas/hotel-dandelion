package hu.hotel;

import hu.hotel.data.read.DataFileReader;
import hu.hotel.data.read.DataReader;
import hu.hotel.data.write.DataFileLogger;
import hu.hotel.data.write.DataLogger;
import hu.hotel.model.StayPeriod;
import hu.hotel.service.BookingService;
import hu.hotel.service.Console;
import hu.hotel.service.DataParser;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class App {

    private final DataReader file;
    private final DataLogger log;
    private final DataParser data;
    private final BookingService bookingService;
    private final Console console;

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    public App() {
        file = new DataFileReader("pitypang.txt");
        log = new DataFileLogger("bevetel.txt");
        data = new DataParser();
        bookingService = data.parse(file.read());
        console = new Console();
    }

    private void println() {
        System.out.println("2. feladat: a leghosszabb szállodai tartózkodás: " + bookingService.getLongestStay());
        System.out.println("4. feladat: " + bookingService.getTotalGuestNights());
        System.out.print("5. feladat: kérem adja meg a nap sorszámát és az eltöltendő éjszakák számát [x y]: ");
        StayPeriod stayPeriod = data.getStayPeriod(console);
        System.out.println(bookingService.getFreeRooms(stayPeriod));
        log.println(bookingService.getTotalPrices());
    }
}
