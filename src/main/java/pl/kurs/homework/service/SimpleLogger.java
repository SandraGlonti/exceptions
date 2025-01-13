package pl.kurs.homework.service;

import java.sql.Timestamp;
import java.time.Instant;

public class SimpleLogger {

    private String[] logEntries = new String[10];
    private int currentIndex = 0;

    public void log(Exception exception) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        String logMessage = timestamp + " // " + exception.getClass().getName();
        if (exception.getMessage() != null) {
            logMessage += exception.getMessage();
        }
        logEntries[currentIndex] = logMessage;
        currentIndex++;
    }

    public void printLogs() {
        System.out.println("Lista zarejestrowanych wyjątków: ");
        if (currentIndex == 0) {
            System.out.println("Brak wyjątków.");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println(logEntries[i]);
            }
        }
    }

}
