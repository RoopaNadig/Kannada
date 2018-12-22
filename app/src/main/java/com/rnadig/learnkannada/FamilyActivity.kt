package com.rnadig.learnkannada

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import kotlinx.android.synthetic.main.word_list.*
import java.util.*

/**
 * Created by  on 03-Jul-16.
 */
class FamilyActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val onCompletionListener = MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words = ArrayList<Word>()
        words.add(Word("mother", "amma", R.drawable.family_mother, R.raw.mom))
        words.add(Word("father", "appa", R.drawable.family_father, R.raw.dad))
        words.add(Word("elder sister", "akka", R.drawable.family_older_sister, R.raw.sis1))
        words.add(Word("younger sister", "thangi", R.drawable.family_younger_sister, R.raw
                .sis2))
        words.add(Word("elder brother", "aNNa", R.drawable.family_older_brother, R.raw.bro1))
        words.add(Word("younger brother", "thamma", R.drawable.family_younger_brother, R.raw
                .bro2))
        words.add(Word("grandmother", "ajji", R.drawable.family_grandmother, R.raw.gmom))
        words.add(Word("grandfather", "ajja", R.drawable.family_grandfather, R.raw.gdad))

        val itemsAdapter = WordAdaptor(this, words, R.color.category_family)

        list.adapter = itemsAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val (_, _, _, audioId) = words[position]
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this@FamilyActivity, audioId)
            mediaPlayer!!.start()
            mediaPlayer!!.setOnCompletionListener(onCompletionListener)
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}
