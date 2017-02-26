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

    /**
     * Constructor.
     * @param bookings - list of {@link Booking}
     */
    public BookingService(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * 2. feladat: Jelenítse meg a képernyőn a leghosszabb szállodai tartózkodást!
     * Csak az időtartamot vegye figyelembe, azaz nem számít, hogy hány vendég lakott az adott szobában!
     * Az esetlegesen azonos hosszúságú tartózkodások közül bármelyiket kiválaszthatja.
     * @return String - a megfelelő válasz
     */
    public String getLongestStay() {
        Booking longestStay = bookings.stream()
                .max(Comparator.comparing(Booking::getNumberOfNights))
                .get();
        return String.format("%s (%d) - %d", longestStay.getName(), longestStay.getArrivalDay(), longestStay.getNumberOfNights());
    }

    /**
     * 3. feladat: Számítsa ki, hogy az egyes foglalások után mennyit kell fizetnie az egyes vendégeknek!
     * A foglalás sorszámát és a kiszámított értékeket kettősponttal elválasztva írja ki a bevetel.txt fájlba!
     * @return String - a megfelelő válasz
     */
    public String getTotalPrices() {
        StringBuilder sb = new StringBuilder();
        bookings.forEach(i -> sb.append(String.format("%d:%d%s", i.getId(), i.getTotalPrice(), NEW_LINE)));
        return sb.toString();
    }

    /**
     * 4. feladat: Készítsen statisztikát az egyes hónapokban eltöltött vendégéjszakákról!
     * Egy vendégéjszakának egy fő egy eltöltött éjszakája számít.
     * A példában szereplő Tóth család áprilisban 3, májusban pedig 9 vendégéjszakát töltött a szállodában.
     * Írassa ki a havi vendégéjszakák számát a képernyőre.
     * @return String - a megfelelő válasz
     */
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

    /**
     * 5. feladat: Kérje be a felhasználótól egy új foglalás kezdő dátumához tartozó nap sorszámát és az
     * eltöltendő éjszakák számát! Határozza meg, hogy hány szoba szabad a megadott időszak teljes időtartamában!
     * A választ írassa ki a képernyőre!
     * @param stayPeriod as {@link StayPeriod} - foglalási idő tól - ig.
     * @return String - a megfelelő válasz
     */
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
                .forEach(i -> rooms[i.getRoom() - 1] = true);
    }
}
