package com.example.android.kannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nsethi on 03-Jul-16.
 */
public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("black", "kappu", R.drawable.color_black, R.raw.black));
        words.add(new Word("white", "beeLi", R.drawable.color_white, R.raw.white));
        words.add(new Word("red", "kempu", R.drawable.color_red, R.raw.red));
        words.add(new Word("gray", "buudu", R.drawable.color_gray, R.raw.gray));
        words.add(new Word("green", "hasiru", R.drawable.color_green, R.raw.green));
        words.add(new Word("yellow", "haLadi", R.drawable.color_mustard_yellow, R.raw.yellow));
        words.add(new Word("brown", "kandu", R.drawable.color_brown, R.raw.brown));

        WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    protected void onStop(){

        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;

        }
    }

}