package com.example.csobey_emotilog.ui.dashboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private SharedViewModel sharedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        ListView listView = binding.emojiHistory;



//        ArrayList<String> historyList = new ArrayList<>();
//        for (EmojiTrackerData temp: sharedViewModel.getCombinedList()){
//            String convertedEmojiData = "Emoji: " + temp.emojiPicID + " At Time: " + temp.timeStamp;
//            historyList.add(convertedEmojiData);
//        }

        ArrayList<EmojiTrackerData> historyList = new ArrayList<>(sharedViewModel.getEmojiHistoryList());

        EmojiAdaptor arrayAdapter = new EmojiAdaptor(requireContext(), historyList);
        listView.setAdapter(arrayAdapter);

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}