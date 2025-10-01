package com.example.csobey_emotilog;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.csobey_emotilog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    private HashMap<Integer, ArrayList<EmojiTrackerData>> emojiTracker;
//
//    protected final int uniqueEmojiCount = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //All Bellow was premade
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ImageButton sadEmoji = findViewById(R.id.sadEmoji);
//        ImageButton sickEmoji = findViewById(R.id.sickEmoji);
//        ImageButton neutralEmoji = findViewById(R.id.neutralEmoji);
//        ImageButton happyEmoji = findViewById(R.id.happyEmoji);
//        ImageButton nsfwEmoji = findViewById(R.id.nsfwEmoji);
//        ImageButton angryEmoji = findViewById(R.id.angryEmoji);
//
//        sadEmoji.setOnClickListener(this);
//        sickEmoji.setOnClickListener(this);
//        neutralEmoji.setOnClickListener(this);
//        happyEmoji.setOnClickListener(this);
//        nsfwEmoji.setOnClickListener(this);
//        angryEmoji.setOnClickListener(this);
//
//        emojiTracker = new HashMap<>();
//
//        for (int i = 0; i <= uniqueEmojiCount; i++){
//            emojiTracker.put(i, new ArrayList<>());
//        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_emojiList, R.id.navigation_summary)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

//    @Override
//    public void onClick (View v) {
//        int tempID = v.getId();
//
//        if(tempID == R.id.sadEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(1).add(tempEmojiTrackerData);
//        } else if (tempID == R.id.sickEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(2).add(tempEmojiTrackerData);
//            Log.d("BUTTON_TEST", "Button works" + emojiTracker.get(2).getLast().timeStamp);
//        } else if (tempID == R.id.neutralEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(3).add(tempEmojiTrackerData);
//        } else if (tempID == R.id.happyEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(4).add(tempEmojiTrackerData);
//        } else if (tempID == R.id.nsfwEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(5).add(tempEmojiTrackerData);
//        } else if (tempID == R.id.angryEmoji) {
//            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
//            tempEmojiTrackerData.logEmoji();
//            emojiTracker.get(6).add(tempEmojiTrackerData);
//        }
//    }


}