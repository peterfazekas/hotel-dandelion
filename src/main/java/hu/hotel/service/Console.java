package hu.hotel.service;

import hu.hotel.model.StayPeriod;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class Console {

    private final Scanner sc;

    public Console() {
        sc = new Scanner(System.in);
    }

    public String readLine() {
        return sc.nextLine();
    }

}
