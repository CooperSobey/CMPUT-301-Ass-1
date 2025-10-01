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
    private int fragmentNum;

    public EmojiAdaptor(Context context, ArrayList<EmojiTrackerData> emojiHistory, int fragmentNum) {
        super(context, 0, emojiHistory);
        this.fragmentNum = fragmentNum;
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

        if(fragmentNum == 1){
            emojiText.setText(data.timeStamp);
        }else if (fragmentNum == 2){
            emojiText.setText(data.getStringCount());
        }else{
            emojiText.setText(" ");
        }

        return view;
    }
}