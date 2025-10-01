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
import com.example.csobey_emotilog.ui.SharedViewModel;

import java.util.ArrayList;
import java.util.HashMap;
/*
HomeFragment works as our home screen "tab"
It has all the emoji buttons and and send all data from clicking emojis to the SharedViewModel class
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private FragmentHomeBinding binding;

    private SharedViewModel sharedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        binding.sadEmoji.setOnClickListener(this);
        binding.sickEmoji.setOnClickListener(this);
        binding.neutralEmoji.setOnClickListener(this);
        binding.happyEmoji.setOnClickListener(this);
        binding.nsfwEmoji.setOnClickListener(this);
        binding.angryEmoji.setOnClickListener(this);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onClick (View v) {
        int tempID = v.getId();

        if(tempID == R.id.sadEmoji) {
            int emojiPicID = R.drawable.crying_face_emoji_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(1, emojiPicID);
            sharedViewModel.saveEmojiClickData(1, tempEmojiTrackerData);

        } else if (tempID == R.id.sickEmoji) {
            int emojiPicID = R.drawable.face_with_thermometer_emoji_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(2, emojiPicID);
            sharedViewModel.saveEmojiClickData(2, tempEmojiTrackerData);

        } else if (tempID == R.id.neutralEmoji) {
            int emojiPicID = R.drawable.neutral_face_emoji_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(3, emojiPicID);
            sharedViewModel.saveEmojiClickData(3, tempEmojiTrackerData);

        } else if (tempID == R.id.happyEmoji) {
            int emojiPicID = R.drawable.slightly_smiling_face_emoji_icon_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(4, emojiPicID);
            sharedViewModel.saveEmojiClickData(4, tempEmojiTrackerData);

        } else if (tempID == R.id.nsfwEmoji) {
            int emojiPicID = R.drawable.tired_face_emoji_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(5, emojiPicID);
            sharedViewModel.saveEmojiClickData(5, tempEmojiTrackerData);

        } else if (tempID == R.id.angryEmoji) {
            int emojiPicID = R.drawable.very_angry_emoji_60x60;
            EmojiTrackerData tempEmojiTrackerData = new EmojiTrackerData(6, emojiPicID);
            sharedViewModel.saveEmojiClickData(6, tempEmojiTrackerData);

        }
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}