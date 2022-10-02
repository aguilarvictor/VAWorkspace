package com.vaworks.mybibleplan


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(
    context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    val dbfile = context?.getDatabasePath("fivedayplan.db")
    /*
    *  Called when the database is created for the first time.
    *  Where the creation of tables and population of tables happen.
    */
    override fun onCreate(db: SQLiteDatabase?) {

        val db= openDatabase(dbfile?.path!!,null,SQLiteDatabase.OPEN_READWRITE) //openOrCreateDatabase("fivedayplan.db", null)
        db?.execSQL(FiveDayDbContract.WeekEntry.SQL_CREATE_ENTRIES)

    }

    /*
    * Called when the database needs to be upgraded.
    *
    */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(FiveDayDbContract.WeekEntry.SQL_DROP_TABLE)
        onCreate(db)
    }

    /*
    * Constants for the table name and version.
    * Version has to be updated everytime schema is modified.
    */
    companion object{
        const val DATABASE_NAME = "fivedayplan.db"
        const val DATABASE_VERSION = 1
    }
}