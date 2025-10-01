package com.example.csobey_emotilog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EmojiAdaptor extends ArrayAdapter<EmojiTrackerData> {
    public EmojiAdaptor(Context context, ArrayList<EmojiTrackerData> emojiHistory) {
        super(context, 0, emojiHistory);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.emoji_with_text_display, parent, false);
        } else {
            view = convertView;
        }
        EmojiTrackerData data = getItem(position);
        ImageView emojiImage = view.findViewById(R.id.emojiImage);
        TextView emojiText = view.findViewById(R.id.emojiText);

        emojiImage.setImageResource(data.emojiPicID);
        emojiText.setText(data.timeStamp);
        return view;
    }
}