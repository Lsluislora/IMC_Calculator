package com.project.imccalculater

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected = true
    private var isFemaleSelected = false

    private lateinit var cardviewFemale: CardView
    private lateinit var cardviewMale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        initListener()
        initUI()

    }

    private fun initUI() {
        setGenderColor()
    }


    private fun initComponent() {
        cardviewFemale = findViewById(R.id.cardviewFemale)
        cardviewMale = findViewById(R.id.cardviewMale)

    }

    private fun initListener() {

        cardviewFemale.setOnClickListener {

            changeGenderColor()
            setGenderColor()
        }

        cardviewMale.setOnClickListener {
            changeGenderColor()
            setGenderColor()
        }

    }

    private fun setGenderColor() {

        cardviewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected));
        cardviewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected));

    }

    private fun changeGenderColor() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun getBackgroundColor(isSelectectComponent: Boolean): Int {

        val referenceColor = if (isSelectectComponent) {
            R.color.selected_background_cardview
        } else {
            R.color.background_cardview
        }

        return ContextCompat.getColor(this, referenceColor)

    }

}