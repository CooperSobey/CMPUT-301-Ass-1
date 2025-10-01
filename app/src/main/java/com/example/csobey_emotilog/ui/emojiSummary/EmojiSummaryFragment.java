package com.example.csobey_emotilog.ui.emojiSummary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csobey_emotilog.databinding.FragmentNotificationsBinding;
import com.example.csobey_emotilog.ui.SharedViewModel;
/*
EmojiSummaryFragment works as the total count "tab"
It has a count for how much each emoji was clicked and the total emojis clicked
 */
public class EmojiSummaryFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EmojiSummaryViewModel emojiSummaryViewModel = new ViewModelProvider(this).get(EmojiSummaryViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);

        binding.textViewSadEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(1)));
        binding.textViewSickEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(2)));
        binding.textViewNeutralEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(3)));
        binding.textViewHappyEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(4)));
        binding.textViewNsfwEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(5)));
        binding.textViewAngryEmoji.setText(String.valueOf(sharedViewModel.emojiFrequencyMap.get(6)));
        binding.textView7.setText("Total Count: " + sharedViewModel.getTotalCount());

        final TextView textView = binding.textNotifications;
        emojiSummaryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}