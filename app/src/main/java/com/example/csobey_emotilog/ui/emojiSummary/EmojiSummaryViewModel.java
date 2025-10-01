package com.example.csobey_emotilog.ui.emojiSummary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//Honestly this came with the preset but I never use it and not 100% sure if I need it but it
// breaks without it
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