package com.rnadig.learnkannada

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import kotlinx.android.synthetic.main.word_list.*
import java.util.*

/**
 * Created by nsethi on 03-Jul-16.
 */
class ColorsActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val completionListener = MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words = ArrayList<Word>()
        words.add(Word("black", "kappu", R.drawable.color_black, R.raw.black))
        words.add(Word("white", "beeLi", R.drawable.color_white, R.raw.white))
        words.add(Word("red", "kempu", R.drawable.color_red, R.raw.red))
        words.add(Word("gray", "buudu", R.drawable.color_gray, R.raw.gray))
        words.add(Word("green", "hasiru", R.drawable.color_green, R.raw.green))
        words.add(Word("yellow", "haLadi", R.drawable.color_mustard_yellow, R.raw.yellow))
        words.add(Word("brown", "kandu", R.drawable.color_brown, R.raw.brown))

        val itemsAdapter = WordAdaptor(this, words, R.color.category_colors)
        list.adapter = itemsAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val (_, _, _, audioId) = words[position]
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this@ColorsActivity, audioId)
            mediaPlayer!!.start()
            mediaPlayer!!.setOnCompletionListener(completionListener)
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