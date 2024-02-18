package com.project.imccalculater

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    private var isMaleSelected = true
    private var isFemaleSelected = false

    private lateinit var cardviewFemale: CardView
    private lateinit var cardviewMale: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView
    private lateinit var weightNumberPicker: NumberPicker
    private lateinit var ageNumberPicker: NumberPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initListener()
        configNumberPicker()
        initUI()

    }

    private fun initUI() {
        setGenderColor()
    }


    private fun initComponent() {
        cardviewFemale = findViewById(R.id.cardviewFemale)
        cardviewMale = findViewById(R.id.cardviewMale)
        rsHeight = findViewById(R.id.rsSetHeight)
        tvHeight = findViewById(R.id.tvSetHeight)
        weightNumberPicker = findViewById(R.id.weightNumberPicker)
        ageNumberPicker = findViewById(R.id.ageNumberPicker)

    }

    private fun initListener() {

        cardviewFemale.setOnClickListener {
            setGenderColor()
            changeGenderColor()

        }

        cardviewMale.setOnClickListener {
            setGenderColor()
            changeGenderColor()

        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val format = DecimalFormat("#.##")
            val result = format.format(value)
            tvHeight.text = result
        }

    }


    private fun setGenderColor() {

        cardviewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardviewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

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

    private fun configNumberPicker(){
        weightNumberPicker.minValue = 0
        weightNumberPicker.maxValue = 300
        weightNumberPicker.value = 50

        ageNumberPicker.minValue = 0
        ageNumberPicker.maxValue = 100
        ageNumberPicker.value = 30



    }



}