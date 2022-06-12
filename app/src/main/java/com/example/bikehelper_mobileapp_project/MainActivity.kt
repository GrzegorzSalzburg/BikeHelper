package com.example.bikehelper_mobileapp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)

    }
    fun bikeQRScanner(view: View){
        val intent = Intent(this,QRScanner::class.java)
        startActivity(intent)
    }

    fun bikeCategoriesView(view:View){
        val intent = Intent(this,BikeCategories::class.java)
        startActivity(intent)
    }
}