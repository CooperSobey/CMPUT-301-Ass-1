package com.example.csobey_emotilog.ui.emojiLog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmojiLogViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EmojiLogViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}