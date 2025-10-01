package com.example.csobey_emotilog.ui.emojiLog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csobey_emotilog.EmojiAdaptor;
import com.example.csobey_emotilog.EmojiTrackerData;
import com.example.csobey_emotilog.databinding.FragmentDashboardBinding;
import com.example.csobey_emotilog.ui.SharedViewModel;

import java.util.ArrayList;
/*
EmojiLogFragment works as the log "tab" for the app
It logs the date and time of each emoji click and presents it as a list
 */
public class EmojiLogFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EmojiLogViewModel emojiLogViewModel = new ViewModelProvider(this).get(EmojiLogViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        ListView listView = binding.emojiHistory;

        ArrayList<EmojiTrackerData> historyList = new ArrayList<>(sharedViewModel.getEmojiHistoryList());

        EmojiAdaptor arrayAdapter = new EmojiAdaptor(requireContext(), historyList, 1);
        listView.setAdapter(arrayAdapter);

        final TextView textView = binding.textDashboard;
        emojiLogViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}