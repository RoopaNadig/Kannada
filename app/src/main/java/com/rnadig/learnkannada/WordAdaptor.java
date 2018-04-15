package com.rnadig.learnkannada;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by  on 09-Jul-16.
 */
public class WordAdaptor extends ArrayAdapter<Word> {

    private int mColorId;

    public WordAdaptor(Activity context, ArrayList<Word> word, int resourceColor) {
        super(context, 0, word);
        mColorId = resourceColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        Word currentWord = getItem(position);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_id);
        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getmImageId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }
        TextView kannadaText = (TextView) listItemView.findViewById(R.id.kannada_id);

        kannadaText.setText(currentWord.getKannada());

        TextView englishText = (TextView) listItemView.findViewById(R.id.english_id);

        englishText.setText(currentWord.getEnglish());

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
