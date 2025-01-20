package pl.kurs.homework.service;

import pl.kurs.homework.model.Log;

import java.sql.Timestamp;
import java.time.Instant;

public class SimpleLogger {
    private Log[] logs;
    private int currentIndex = 0;

    public SimpleLogger(int capacity) {
        logs = new Log[capacity];
        currentIndex = 0;
    }


    public void log(Exception exception) {
        if (currentIndex >= logs.length) {
            Log[] newLogs = new Log[logs.length + 2];
            System.arraycopy(logs, 0, newLogs, 0, logs.length);
            logs = newLogs;
        }
        Timestamp timestamp = Timestamp.from(Instant.now());
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
        logs[currentIndex] = new Log(timestamp, exceptionType, exceptionMessage);
        currentIndex++;
    }

    public void showLogs() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(logs[i]);
        }
    }

}
