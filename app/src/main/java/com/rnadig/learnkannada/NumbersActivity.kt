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
class NumbersActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val onCompletionListener = MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words = ArrayList<Word>()
        words.add(Word("one", "ondu", R.drawable.number_one, R.raw.one))
        words.add(Word("two", "yeradu", R.drawable.number_two, R.raw.two))
        words.add(Word("three", "muuru", R.drawable.number_three, R.raw.three))
        words.add(Word("four", "nalakku", R.drawable.number_four, R.raw.four))
        words.add(Word("five", "aidhu", R.drawable.number_five, R.raw.five))
        words.add(Word("six", "aaru", R.drawable.number_six, R.raw.six))
        words.add(Word("seven", "yeLu", R.drawable.number_seven, R.raw.seven))
        words.add(Word("eight", "yentu", R.drawable.number_eight, R.raw.eight))
        words.add(Word("nine", "ombathu", R.drawable.number_nine, R.raw.nine))
        words.add(Word("ten", "hathu", R.drawable.number_ten, R.raw.ten))

        val itemsAdapter = WordAdaptor(this, words, R.color.category_numbers)
        list.adapter = itemsAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val (_, _, _, audioId) = words[position]
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this@NumbersActivity, audioId)
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
