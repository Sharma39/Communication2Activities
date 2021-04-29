package com.example.a3communication2activities.model;

import java.io.Serializable;

public class CustomMessage implements Serializable {

    private String timesent;
    private String message;

    public CustomMessage(String timesent, String message) {
        this.timesent = timesent;
        this.message = message;
    }

    public String getTimesent() {
        return timesent;
    }

    public void setTimesent(String timesent) {
        this.timesent = timesent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "timesent='" + timesent + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
