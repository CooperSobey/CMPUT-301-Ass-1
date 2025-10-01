package com.example.csobey_emotilog.ui;

import androidx.lifecycle.ViewModel;

import com.example.csobey_emotilog.EmojiTrackerData;

import java.util.ArrayList;
import java.util.HashMap;

/*
SharedViewModel works as our data storing class
It takes all the data from HomeFragment's button clicks and keeps them here so they are maintained
when we switch between our "tabs"
 */
public class SharedViewModel extends ViewModel {

    public HashMap<Integer, ArrayList<EmojiTrackerData>> emojiTracker = new HashMap<>();
    public ArrayList<EmojiTrackerData> emojiHistoryList = new ArrayList<>();
    public HashMap<Integer, Integer> emojiFrequencyMap = new HashMap<>();

    private int totalCount;

    public SharedViewModel() {
        int uniqueEmojiCount = 6;
        for (int i = 0; i <= uniqueEmojiCount; i++){
            emojiTracker.put(i, new ArrayList<>());
            emojiFrequencyMap.put(i, 0);
        }

        totalCount = 0;
    }

    public HashMap<Integer, ArrayList<EmojiTrackerData>> getEmojiTracker() {
        return emojiTracker;
    }

    public void saveEmojiClickData(int emojiID, EmojiTrackerData clickData) {
        int tempCount;
        if(emojiTracker.containsKey(emojiID)){
            tempCount = emojiFrequencyMap.get(emojiID);
            tempCount++;
            totalCount++;
            emojiTracker.get(emojiID).add(clickData);
            emojiFrequencyMap.put(emojiID, tempCount);
        }

        emojiHistoryList.add(clickData);
    }

    public ArrayList<EmojiTrackerData> getEmojiHistoryList() {
        return emojiHistoryList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public ArrayList<EmojiTrackerData> getCombinedList() {
        ArrayList<EmojiTrackerData> combinedList = new ArrayList<>();

        for (ArrayList<EmojiTrackerData> temp: emojiTracker.values()){
            combinedList.addAll(temp);
        }

        return combinedList;
    }
}
