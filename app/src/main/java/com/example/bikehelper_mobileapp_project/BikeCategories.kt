package com.example.bikehelper_mobileapp_project


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class BikeCategories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_categories)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)
    }

    fun BikeListClick(view: View){

        var bt_text=""

        when (view.getId()) {
            R.id.buttonact1 -> {bt_text="mtb"}
            R.id.buttonact2 -> {bt_text="road"}
            R.id.buttonact3 -> {bt_text="ebike"}
            R.id.buttonact4 -> {bt_text="city"}
        }
        val intent = Intent(this, BikeList::class.java).apply {
            putExtra("bike_type", bt_text)
        }
        startActivity(intent)
    }


}