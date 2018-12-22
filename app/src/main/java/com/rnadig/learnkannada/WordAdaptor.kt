package com.rnadig.learnkannada

import android.app.Activity
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by  on 09-Jul-16.
 */
class WordAdaptor(context: Activity, word: ArrayList<Word>, private val colorId: Int)
    : ArrayAdapter<Word>(context, 0, word) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,
                    false)
        }

        val currentWord = getItem(position)
        val image = listItemView!!.findViewById<ImageView>(R.id.image_id)
        if (currentWord != null && currentWord.imageId != -1) {
            image.setImageResource(currentWord.imageId)
            image.visibility = View.VISIBLE
        } else {
            image.visibility = View.GONE
        }

        val kannadaText = listItemView.findViewById<TextView>(R.id.kannada_id)

        kannadaText.text = currentWord!!.kannadaTranslation

        val englishText = listItemView.findViewById<TextView>(R.id.english_id)

        englishText.text = currentWord.englishTranslation

        val textContainer = listItemView.findViewById<View>(R.id.text_container)

        val color = ContextCompat.getColor(context, colorId)

        textContainer.setBackgroundColor(color)

        return listItemView
    }
}
