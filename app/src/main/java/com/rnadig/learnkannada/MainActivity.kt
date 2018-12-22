package com.rnadig.learnkannada

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numbers.setOnClickListener {
            val numbersIntent = Intent(this@MainActivity, NumbersActivity::class.java)
            startActivity(numbersIntent)
        }

        family.setOnClickListener {
            val familyIntent = Intent(this@MainActivity, FamilyActivity::class.java)
            startActivity(familyIntent)
        }

        colors.setOnClickListener {
            val colorsIntent = Intent(this@MainActivity, ColorsActivity::class.java)
            startActivity(colorsIntent)
        }

        phrases.setOnClickListener {
            val phrasesIntent = Intent(this@MainActivity, PhrasesActivity::class.java)
            startActivity(phrasesIntent)
        }
    }

}

