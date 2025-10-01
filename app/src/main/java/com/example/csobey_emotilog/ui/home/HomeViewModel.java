package com.example.csobey_emotilog.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//Honestly this came with the preset but I never use it and not 100% sure if I need it but it
// breaks without it
public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Select an Emoji!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}