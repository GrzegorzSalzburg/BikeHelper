package com.example.bikehelper_mobileapp_project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context,"BIKESDB",null,2) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE BIKES(BIKESID INTEGER PRIMARY KEY AUTOINCREMENT, BIKECODE INTEGER, BIKETYPE TEXT)")
        db?.execSQL("INSERT INTO BIKES(BIKECODE, BIKETYPE) VALUES (1000,'mtb')")
        db?.execSQL("INSERT INTO BIKES(BIKECODE, BIKETYPE) VALUES (1001,'road')")
        db?.execSQL("INSERT INTO BIKES(BIKECODE, BIKETYPE) VALUES (1002,'ebike')")
        db?.execSQL("INSERT INTO BIKES(BIKECODE, BIKETYPE) VALUES (1003,'city')")

        db?.execSQL("CREATE TABLE BIKEDESCRIPTION(BIKEDESCRIPTIONID INTEGER PRIMARY KEY AUTOINCREMENT, BIKETYPE TEXT,BRANDNAME TEXT, MODELTYPE TEXT, COLOR TEXT)")
        db?.execSQL("INSERT INTO BIKEDESCRIPTION(BIKETYPE, BRANDNAME, MODELTYPE, COLOR) VALUES ('mtb','scott','scale','red')")
        db?.execSQL("INSERT INTO BIKEDESCRIPTION(BIKETYPE, BRANDNAME, MODELTYPE, COLOR) VALUES ('road','scott','addict','blue')")
        db?.execSQL("INSERT INTO BIKEDESCRIPTION(BIKETYPE, BRANDNAME, MODELTYPE, COLOR) VALUES ('ebike','scott','strike','cyan')")
        db?.execSQL("INSERT INTO BIKEDESCRIPTION(BIKETYPE, BRANDNAME, MODELTYPE, COLOR) VALUES ('city','scott','sub','black')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}