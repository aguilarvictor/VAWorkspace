package com.vaworks.mybibleplan

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object FiveDayDbContract {
    object WeekEntry: BaseColumns{
        const val TABLE_NAME = "weeklyprogram"
        const val COLUMN_ID = _ID
        const val COLUMN_DAYONE = "dayone"
        const val COLUMN_CHECKONE = "checkone"
        const val COLUMN_DAYTWO = "daytwo"
        const val COLUMN_CHECKTWO = "checktwo"
        const val COLUMN_DAYTHREE = "daythree"
        const val COLUMN_CHECKTHREE = "checkthree"
        const val COLUMN_DAYFOUR = "dayfour"
        const val COLUMN_CHECKFOUR = "checkfour"
        const val COLUMN_DAYFIVE = "dayfive"
        const val COLUMN_CHECKFIVE = "checkfive"

        /*
        * Query to create table according to Contract class.
        */
        const val SQL_CREATE_ENTRIES: String =
            "CREATE TABLE ${TABLE_NAME} (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${COLUMN_DAYONE} TEXT NOT NULL, " +
                    "${COLUMN_CHECKONE} INTEGER NOT NULL, " +
                    "${COLUMN_DAYTWO} TEXT NOT NULL, " +
                    "${COLUMN_CHECKTWO} INTEGER NOT NULL, " +
                    "${COLUMN_DAYTHREE} TEXT NOT NULL, " +
                    "${COLUMN_CHECKTHREE} INTEGER NOT NULL, " +
                    "${COLUMN_DAYFOUR} TEXT NOT NULL, " +
                    "${COLUMN_CHECKFOUR} INTEGER NOT NULL, " +
                    "${COLUMN_DAYFIVE} TEXT NOT NULL, " +
                    "${COLUMN_CHECKFIVE} INTEGER NOT NULL)"


        /*
        * Query to drop the table
        */
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"
    }
}