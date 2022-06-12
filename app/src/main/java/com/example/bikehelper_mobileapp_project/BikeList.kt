package com.example.bikehelper_mobileapp_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat

class BikeList : AppCompatActivity() {

    private val arrayListBikeCodes = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_list)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)

        var bikeType = intent.getStringExtra("bike_type")

        var helper = DBHelper(applicationContext)
        var db = helper.readableDatabase

        if (bikeType == "mtb") {
            var query = db.rawQuery("SELECT * FROM BIKES WHERE BIKETYPE LIKE "+"mtb", null)
            while (query.moveToNext()) {
                var bikes = query.getString(1)
                arrayListBikeCodes.add(bikes)
            }
            //array adapter, used to drop items from arraylist of repos to list view
            val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListBikeCodes)
            val listViewVal = findViewById<ListView>(R.id.bikeList)
            listViewVal.adapter = adapter

        } else if (bikeType == "road"){
            var query1 = db.rawQuery("SELECT * FROM BIKES WHERE BIKETYPE LIKE "+"road", null)
            while (query1.moveToNext()) {
                var bikes = query1.getString(1)
                arrayListBikeCodes.add(bikes)
            }
            //array adapter, used to drop items from arraylist of repos to list view
            val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListBikeCodes)
            val listViewVal = findViewById<ListView>(R.id.bikeList)
            listViewVal.adapter = adapter

        } else if (bikeType =="ebike"){
            var query2 = db.rawQuery("SELECT * FROM BIKES WHERE BIKETYPE LIKE "+"ebike", null)
            while (query2.moveToNext()) {
                var bikes = query2.getString(1)
                arrayListBikeCodes.add(bikes)
            }
            //array adapter, used to drop items from arraylist of repos to list view
            val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListBikeCodes)
            val listViewVal = findViewById<ListView>(R.id.bikeList)
            listViewVal.adapter = adapter

        } else {
            var query3 = db.rawQuery("SELECT * FROM BIKES WHERE BIKETYPE LIKE "+"city", null)
            while (query3.moveToNext()) {
                var bikes = query3.getString(1)
                arrayListBikeCodes.add(bikes)
            }
            //array adapter, used to drop items from arraylist of repos to list view
            val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListBikeCodes)
            val listViewVal = findViewById<ListView>(R.id.bikeList)
            listViewVal.adapter = adapter
        }

    }
}