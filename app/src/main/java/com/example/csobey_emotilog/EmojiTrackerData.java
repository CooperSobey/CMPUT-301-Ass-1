package com.example.csobey_emotilog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
EmojiTrackerData is the object which we store all of our click data.
Each click makes a new one of these and stores it in SharedViewModels hashmap
 */
public class EmojiTrackerData {
    public int emojiID;
    public int emojiPicID;
    public int count;
    public String stringCount;
    private LocalDateTime dateTime;
    public String timeStamp;

    //Base Emoji values and calls log emoji to set time stamps
    public EmojiTrackerData(int emojiID, int emojiPicID){
        this.count = 0;
        this.timeStamp = "0";
        this.emojiID = emojiID;
        this.emojiPicID = emojiPicID;
        logEmoji();
    }

    //Logs emoji with timestamps
    public void logEmoji(){
        this.dateTime = java.time.LocalDateTime.now();
        this.timeStamp = timeStampFormat();
    }

    //Formats the time stamp so its readable and asthetic
    public String timeStampFormat(){
        String tempTimeStamp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        tempTimeStamp = dateTime.format(formatter);
        return tempTimeStamp;
    }

    //Getters and Setters
    public int getCount() {
        return count;
    }

    public String getTime() {
        return timeStamp;
    }

    public String getStringCount() {
        stringCount = String.valueOf(count);
        return stringCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
