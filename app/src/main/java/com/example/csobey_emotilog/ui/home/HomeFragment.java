package com.example.csobey_emotilog.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csobey_emotilog.EmojiTrackerData;
import com.example.csobey_emotilog.R;
import com.example.csobey_emotilog.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private FragmentHomeBinding binding;

    private HashMap<Integer, ArrayList<EmojiTrackerData>> emojiTracker;

    protected final int uniqueEmojiCount = 6;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageButton sadEmoji = root.findViewById(R.id.sadEmoji);
        ImageButton sickEmoji = root.findViewById(R.id.sickEmoji);
        ImageButton neutralEmoji = root.findViewById(R.id.neutralEmoji);
        ImageButton happyEmoji = root.findViewById(R.id.happyEmoji);
        ImageButton nsfwEmoji = root.findViewById(R.id.nsfwEmoji);
        ImageButton angryEmoji = root.findViewById(R.id.angryEmoji);

        sadEmoji.setOnClickListener(this);
        sickEmoji.setOnClickListener(this);
        neutralEmoji.setOnClickListener(this);
        happyEmoji.setOnClickListener(this);
        nsfwEmoji.setOnClickListener(this);
        angryEmoji.setOnClickListener(this);

        emojiTracker = new HashMap<>();

        for (int i = 0; i <= uniqueEmojiCount; i++){
            emojiTracker.put(i, new ArrayList<>());
        }


        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onClick (View v) {
        int tempID = v.getId();

        if(tempID == R.id.sadEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(1).add(tempEmojiTrackerData);
        } else if (tempID == R.id.sickEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(2).add(tempEmojiTrackerData);
            Log.d("BUTTON_TEST", "Button works" + emojiTracker.get(2).getLast().timeStamp);
        } else if (tempID == R.id.neutralEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(3).add(tempEmojiTrackerData);
            Log.d("BUTTON_TEST", "Button works" + emojiTracker.get(2).getLast().timeStamp);
        } else if (tempID == R.id.happyEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(4).add(tempEmojiTrackerData);
        } else if (tempID == R.id.nsfwEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(5).add(tempEmojiTrackerData);
        } else if (tempID == R.id.angryEmoji) {
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData();
            tempEmojiTrackerData.logEmoji();
            emojiTracker.get(6).add(tempEmojiTrackerData);
        }
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}