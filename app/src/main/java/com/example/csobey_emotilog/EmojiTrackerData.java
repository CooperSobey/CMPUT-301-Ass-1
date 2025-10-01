package com.example.csobey_emotilog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmojiTrackerData {
    public int count;
    private LocalDateTime dateTime;
    public String timeStamp;

    public EmojiTrackerData(){
        this.count = 0;
        this.timeStamp = "0";
    }

    public void logEmoji(){
        count ++;
        this.dateTime = java.time.LocalDateTime.now();
        this.timeStamp = timeStampFormat();
    }

    public String timeStampFormat(){
        String tempTimeStamp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        tempTimeStamp = dateTime.format(formatter);
        return tempTimeStamp;
    }

    public int getCount() {
        return count;
    }

    public String getTime() {
        return timeStamp;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
