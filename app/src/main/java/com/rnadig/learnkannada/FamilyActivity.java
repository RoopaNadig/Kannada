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
public class FamilyActivity extends AppCompatActivity {

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

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("mother", "amma", R.drawable.family_mother, R.raw.mom));
        words.add(new Word("father", "appa", R.drawable.family_father, R.raw.dad));
        words.add(new Word("elder sister", "akka", R.drawable.family_older_sister, R.raw.sis1));
        words.add(new Word("younger sister", "thangi", R.drawable.family_younger_sister, R.raw
                .sis2));
        words.add(new Word("elder brother", "aNNa", R.drawable.family_older_brother, R.raw.bro1));
        words.add(new Word("younger brother", "thamma", R.drawable.family_younger_brother, R.raw
                .bro2));
        words.add(new Word("grandmother", "ajji", R.drawable.family_grandmother, R.raw.gmom));
        words.add(new Word("grandfather", "ajja", R.drawable.family_grandfather, R.raw.gdad));

        final WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_family);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioId());
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