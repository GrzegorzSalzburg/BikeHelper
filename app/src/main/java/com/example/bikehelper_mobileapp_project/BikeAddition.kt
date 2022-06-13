package com.example.bikehelper_mobileapp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class BikeAddition : AppCompatActivity() {

    private lateinit var bikecodetv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_addition)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)

        bikecodetv = findViewById(R.id.bikeCodetv)
        bikecodetv.text=intent.getStringExtra("bike_code_data")
    }

     fun addBike(view: View){
        val bikeCodeVal=findViewById<TextView>(R.id.bikeCodetv).text
        val bikeTypeVal=findViewById<EditText>(R.id.bikeTypetv).text
        val brandNameVal=findViewById<EditText>(R.id.brandNametv).text
        val modelNameVal=findViewById<EditText>(R.id.modelNametv).text
        val bikeColorVal=findViewById<EditText>(R.id.bikeColortv).text

        if (bikeCodeVal.isNullOrEmpty()||bikeTypeVal.isNullOrEmpty()||brandNameVal.isNullOrEmpty()||modelNameVal.isNullOrEmpty()||bikeColorVal.isNullOrEmpty())
            Toast.makeText(applicationContext, "All the fields have to be filled", Toast.LENGTH_SHORT).show()
        else {
            Toast.makeText(applicationContext, "Added bike to Db", Toast.LENGTH_SHORT).show()
            var helper=DBHelper(applicationContext)
            var db=helper.readableDatabase

            db?.execSQL("INSERT INTO BIKEDESCRIPTION(BRANDNAME, MODELTYPE, COLOR) VALUES ('"+brandNameVal+"','"+modelNameVal+"','"+bikeColorVal+"')")
            db?.execSQL("INSERT INTO BIKES(BIKECODE, BIKETYPE) VALUES ('"+bikeCodeVal+"','"+bikeTypeVal+"')")

            val intent = Intent(this,QRScanner::class.java)
            startActivity(intent)
        }
    }
}