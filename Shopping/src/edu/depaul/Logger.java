package edu.depaul;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


// Logger class for handling log messages
public class Logger {
    private static final String LOG_FILE = "Log.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestampedMessage = getTimestamp() + " " + message;
            writer.write(timestampedMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimestamp() {
        return dateFormat.format(new Date());
    }
}