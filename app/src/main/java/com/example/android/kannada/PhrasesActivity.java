package com.example.android.kannada;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nsethi on 03-Jul-16.
 */
public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("done", "aaythu"));
        words.add(new Word("yes","howdu"));
        words.add(new Word("no","illa"));
        words.add(new Word("who","yaaru"));
        words.add(new Word("what", "yenu"));
        words.add(new Word("why", "yaake"));
        words.add(new Word("when", "yavaga"));
        words.add(new Word("how much", "yestu"));
        words.add(new Word("how", "heygey"));
        words.add(new Word("breakfast", "thindi"));
        words.add(new Word("lunch/dinner", "oota"));
        words.add(new Word("sleep", "niddey"));
        words.add(new Word("ours","namdu"));
        words.add(new Word("yours","nimdu"));
        words.add(new Word("do", "madi"));
        words.add(new Word("please","dayaviTTu"));
        words.add(new Word("sorry","kShamisi"));
        words.add(new Word("want","beku"));
        words.add(new Word("dont want","beda"));
        words.add(new Word("take","tagoLi"));
        words.add(new Word("give","kodi"));
        words.add(new Word("come","banni"));
        words.add(new Word("this","idhu"));
        words.add(new Word("that","adhu"));
        words.add(new Word("there","alli"));
        words.add(new Word("here","illi"));
        words.add(new Word("listen","keyLi"));
        words.add(new Word("tell","heyLi"));
        words.add(new Word("inside","olage"));
        words.add(new Word("outside","horage"));

        words.add(new Word("what is your name","nimma heysaru yenu?"));
        words.add(new Word("do well", "chennagi madi"));
        words.add(new Word("how are you?", "heygey iddira?"));
        words.add(new Word("where do you work?", "neevu yelli kelsa madodhu?"));
        words.add(new Word("which is your hometown?", "nimma ooru yavudu?"));
        words.add(new Word("where is your home?", "nimma mane yelli?"));
        words.add(new Word("Come home","manege banni"));
        words.add(new Word("lets go","hogona"));



        WordAdaptor itemsAdapter = new WordAdaptor(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}