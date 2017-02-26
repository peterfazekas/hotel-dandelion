package hu.hotel.data.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class DataFileLogger implements DataLogger {

    private static final String PATH = "src\\main\\resources\\";

    private final String fileName;

    public DataFileLogger(final String fileName) {
        this.fileName = PATH + fileName;
        deleteFile();
    }

    private void deleteFile() {
        File log = new File(fileName);
        log.delete();
    }

    @Override
    public void println(String text) {
        try (PrintWriter file = new PrintWriter(new FileWriter(fileName, true))){
            file.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
