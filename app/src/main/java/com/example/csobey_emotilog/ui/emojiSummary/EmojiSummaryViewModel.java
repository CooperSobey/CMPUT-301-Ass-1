package com.example.csobey_emotilog.ui.emojiSummary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmojiSummaryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EmojiSummaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}