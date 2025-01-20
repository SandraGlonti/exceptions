package pl.kurs.homework.model;

import java.sql.Timestamp;

public class Log {
    private Timestamp timestamp;
    private String exceptionType;
    private String message;

    public Log(Timestamp timestamp, String exceptionType, String message) {
        this.timestamp = timestamp;
        this.exceptionType = exceptionType;
        this.message = message != null ? message : "";
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Log{" + timestamp + " // " + exceptionType + " // " + message + '}';
    }
}
