package com.example.bikehelper_mobileapp_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.SearchView.OnQueryTextListener
import androidx.core.content.ContextCompat

class BikeSearch : AppCompatActivity() {

    private val arrayAllBikes = ArrayList<String>()
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_search)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkgrey)

        var helper = DBHelper(applicationContext)
        var db = helper.readableDatabase

        var query = db.rawQuery("SELECT * FROM BIKES", null)
        var queryst = db.rawQuery("SELECT * FROM BIKEDESCRIPTION", null)
        while (query.moveToNext() && queryst.moveToNext()) {
            var bikes = "Bike code: "+query.getString(1)+"\nBike type: "+query.getString(2)+
                    "\nBrand name: "+queryst.getString(2)+ "\nModel name: "+queryst.getString(3)+
                    "\nModel color: "+queryst.getString(4)
            arrayAllBikes.add(bikes)
        }
        //array adapter, used to drop items from arraylist of repos to list view
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayAllBikes)
        val listViewVal = findViewById<ListView>(R.id.searchlist)
        listViewVal.adapter = adapter

        searchView=findViewById(R.id.sV_search)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if(arrayAllBikes.contains(p0)){
                    adapter.filter.filter(p0)
                } else {
                    Toast.makeText(applicationContext, "No match", Toast.LENGTH_SHORT).show()
                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

    }
}