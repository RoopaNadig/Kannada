package com.rnadig.learnkannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by  on 03-Jul-16.
 */
public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer
            .OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("one", "ondu", R.drawable.number_one, R.raw.one));
        words.add(new Word("two", "yeradu", R.drawable.number_two, R.raw.two));
        words.add(new Word("three", "muuru", R.drawable.number_three, R.raw.three));
        words.add(new Word("four", "nalakku", R.drawable.number_four, R.raw.four));
        words.add(new Word("five", "aidhu", R.drawable.number_five, R.raw.five));
        words.add(new Word("six", "aaru", R.drawable.number_six, R.raw.six));
        words.add(new Word("seven", "yeLu", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("eight", "yentu", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("nine", "ombathu", R.drawable.number_nine, R.raw.nine));
        words.add(new Word("ten", "hathu", R.drawable.number_ten, R.raw.ten));

        WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;

        }
    }
}
