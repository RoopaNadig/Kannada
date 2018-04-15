package com.rnadig.learnkannada;

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
public class PhrasesActivity extends AppCompatActivity {
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
        words.add(new Word("done", "aaythu", R.raw.done));
        words.add(new Word("yes", "howdu", R.raw.yes));
        words.add(new Word("no", "illa", R.raw.no));
        words.add(new Word("who", "yaaru", R.raw.who));
        words.add(new Word("what", "yenu", R.raw.what));
        words.add(new Word("why", "yaake", R.raw.why));
        words.add(new Word("when", "yavaga", R.raw.when));
        words.add(new Word("where", "yelli", R.raw.where));
        words.add(new Word("how much", "yestu", R.raw.hmuch));
        words.add(new Word("how", "heygey", R.raw.how));
        words.add(new Word("breakfast", "thindi", R.raw.bf));
        words.add(new Word("lunch/dinner", "oota", R.raw.lunch));
        words.add(new Word("sleep", "niddey", R.raw.sleep));
        words.add(new Word("ours", "namdu", R.raw.ours));
        words.add(new Word("yours", "nimdu", R.raw.yours));
        words.add(new Word("do", "madi", R.raw.dokan));
        words.add(new Word("please", "dayaviTTu", R.raw.please));
        words.add(new Word("sorry", "kShamisi", R.raw.sorry));
        words.add(new Word("thank you", "dhanyavadaGaLu", R.raw.ty));
        words.add(new Word("want", "beku", R.raw.want));
        words.add(new Word("don't want", "beda", R.raw.dwant));
        words.add(new Word("take", "tagoLi", R.raw.take));
        words.add(new Word("give", "kodi", R.raw.give));
        words.add(new Word("come", "banni", R.raw.come));
        words.add(new Word("this", "idhu", R.raw.thiskan));
        words.add(new Word("that", "adhu", R.raw.that));
        words.add(new Word("there", "alli", R.raw.there));
        words.add(new Word("here", "illi", R.raw.here));
        words.add(new Word("listen", "keyLi", R.raw.listen));
        words.add(new Word("tell", "heyLi", R.raw.tell));
        words.add(new Word("inside", "oLage", R.raw.inside));
        words.add(new Word("outside", "horage", R.raw.outside));
        words.add(new Word("do well", "chennagi madi", R.raw.dowell));
        words.add(new Word("come home", "manege banni", R.raw.chome));
        words.add(new Word("let's go", "hogona", R.raw.letsgo));
        words.add(new Word("what is your name?", "nimma heysaru yenu?", R.raw.name));
        words.add(new Word("how are you?", "heygey iddira?", R.raw.hru));
        words.add(new Word("where do you work?", "neevu yelli kelsa madodhu?", R.raw.wuwork));
        words.add(new Word("which is your hometown?", "nimma ooru yavudu?", R.raw.hometown));
        words.add(new Word("where is your home?", "nimma mane yelli?", R.raw.whome));
        words.add(new Word("will you go to silk board?", "silk board hogthira?", R.raw.silkboard));


        WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioId());
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