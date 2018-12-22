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
class PhrasesActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val onCompletionListener = MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words = ArrayList<Word>()
        words.add(Word("done", "aaythu", R.raw.done))
        words.add(Word("yes", "howdu", R.raw.yes))
        words.add(Word("no", "illa", R.raw.no))
        words.add(Word("who", "yaaru", R.raw.who))
        words.add(Word("what", "yenu", R.raw.what))
        words.add(Word("why", "yaake", R.raw.why))
        words.add(Word("when", "yavaga", R.raw.`when`))
        words.add(Word("where", "yelli", R.raw.where))
        words.add(Word("how much", "yestu", R.raw.hmuch))
        words.add(Word("how", "heygey", R.raw.how))
        words.add(Word("breakfast", "thindi", R.raw.bf))
        words.add(Word("lunch/dinner", "oota", R.raw.lunch))
        words.add(Word("sleep", "niddey", R.raw.sleep))
        words.add(Word("ours", "namdu", R.raw.ours))
        words.add(Word("yours", "nimdu", R.raw.yours))
        words.add(Word("do", "madi", R.raw.dokan))
        words.add(Word("please", "dayaviTTu", R.raw.please))
        words.add(Word("sorry", "kShamisi", R.raw.sorry))
        words.add(Word("thank you", "dhanyavadaGaLu", R.raw.ty))
        words.add(Word("want", "beku", R.raw.want))
        words.add(Word("don't want", "beda", R.raw.dwant))
        words.add(Word("take", "tagoLi", R.raw.take))
        words.add(Word("give", "kodi", R.raw.give))
        words.add(Word("come", "banni", R.raw.come))
        words.add(Word("this", "idhu", R.raw.thiskan))
        words.add(Word("that", "adhu", R.raw.that))
        words.add(Word("there", "alli", R.raw.there))
        words.add(Word("here", "illi", R.raw.here))
        words.add(Word("listen", "keyLi", R.raw.listen))
        words.add(Word("tell", "heyLi", R.raw.tell))
        words.add(Word("inside", "oLage", R.raw.inside))
        words.add(Word("outside", "horage", R.raw.outside))
        words.add(Word("do well", "chennagi madi", R.raw.dowell))
        words.add(Word("come home", "manege banni", R.raw.chome))
        words.add(Word("let's go", "hogona", R.raw.letsgo))
        words.add(Word("what is your name?", "nimma heysaru yenu?", R.raw.name))
        words.add(Word("how are you?", "heygey iddira?", R.raw.hru))
        words.add(Word("where do you work?", "neevu yelli kelsa madodhu?", R.raw.wuwork))
        words.add(Word("which is your hometown?", "nimma ooru yavudu?", R.raw.hometown))
        words.add(Word("where is your home?", "nimma mane yelli?", R.raw.whome))
        words.add(Word("will you go to silk board?", "silk board hogthira?", R.raw.silkboard))


        val itemsAdapter = WordAdaptor(this, words, R.color.category_phrases)
        list.adapter = itemsAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val (_, _, _, audioId) = words[position]
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this@PhrasesActivity, audioId)
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