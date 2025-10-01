package com.example.csobey_emotilog.ui;

import androidx.lifecycle.ViewModel;

import com.example.csobey_emotilog.EmojiTrackerData;

import java.util.ArrayList;
import java.util.HashMap;

public class SharedViewModel extends ViewModel {

    public HashMap<Integer, ArrayList<EmojiTrackerData>> emojiTracker = new HashMap<>();
    public ArrayList<EmojiTrackerData> emojiHistoryList = new ArrayList<>();

    private final int uniqueEmojiCount = 6;

    public SharedViewModel() {
        for (int i = 0; i <= uniqueEmojiCount; i++){
            emojiTracker.put(i, new ArrayList<>());
        }
    }

    public HashMap<Integer, ArrayList<EmojiTrackerData>> getEmojiTracker() {
        return emojiTracker;
    }

    public void saveEmojiClickData(int emojiID, EmojiTrackerData clickData) {
        if(emojiTracker.containsKey(emojiID)){
            emojiTracker.get(emojiID).add(clickData);
        }

        emojiHistoryList.add(clickData);
    }

    public ArrayList<EmojiTrackerData> getEmojiHistoryList() {
        return emojiHistoryList;
    }

    public ArrayList<EmojiTrackerData> getCombinedList() {
        ArrayList<EmojiTrackerData> combinedList = new ArrayList<>();

        for (ArrayList<EmojiTrackerData> temp: emojiTracker.values()){
            combinedList.addAll(temp);
        }

        return combinedList;
    }
}
