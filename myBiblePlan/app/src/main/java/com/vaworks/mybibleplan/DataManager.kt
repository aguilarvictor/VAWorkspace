package com.vaworks.mybibleplan

import com.vaworks.mybibleplan.FiveDayDbContract.WeekEntry

object DataManager {
    fun fetchAllPlan (databaseHelper: DatabaseHelper): ArrayList<FiveDayWeeklyProgram>{
        val weeks = ArrayList<FiveDayWeeklyProgram>()

        /* Open database connection */
        val db = databaseHelper.readableDatabase

        /* Create the array of column names */
        val columns = arrayOf(
            WeekEntry.COLUMN_ID,
            WeekEntry.COLUMN_DAYONE,
            WeekEntry.COLUMN_CHECKONE,
            WeekEntry.COLUMN_DAYTWO,
            WeekEntry.COLUMN_CHECKTWO,
            WeekEntry.COLUMN_DAYTHREE,
            WeekEntry.COLUMN_CHECKTHREE,
            WeekEntry.COLUMN_DAYFOUR,
            WeekEntry.COLUMN_CHECKFOUR,
            WeekEntry.COLUMN_DAYFIVE,
            WeekEntry.COLUMN_CHECKFIVE
        )

        /* Call query() function to fetch the data */
        val cursor = db.query(
            WeekEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        /* Fetch the position of the columns */
        val idPos = cursor.getColumnIndex(WeekEntry.COLUMN_ID)
        val dayonePos = cursor.getColumnIndex(WeekEntry.COLUMN_DAYONE)
        val checkonePos = cursor.getColumnIndex(WeekEntry.COLUMN_CHECKONE)
        val daytwoPos = cursor.getColumnIndex(WeekEntry.COLUMN_DAYTWO)
        val checktwoPos = cursor.getColumnIndex(WeekEntry.COLUMN_CHECKTWO)
        val daythreePos = cursor.getColumnIndex(WeekEntry.COLUMN_DAYTHREE)
        val checkthreePos = cursor.getColumnIndex(WeekEntry.COLUMN_CHECKTHREE)
        val dayfourPos = cursor.getColumnIndex(WeekEntry.COLUMN_DAYFOUR)
        val checkfourPos = cursor.getColumnIndex(WeekEntry.COLUMN_CHECKFOUR)
        val dayfivePos = cursor.getColumnIndex(WeekEntry.COLUMN_DAYFIVE)
        val checkfivePos = cursor.getColumnIndex(WeekEntry.COLUMN_CHECKFIVE)

        /* Fetch all columns */
        while (cursor.moveToNext()){
            val id = cursor.getInt(idPos)
            val dayone = cursor.getString(dayonePos)
            val checkone = cursor.getInt(checkonePos)
            val daytwo = cursor.getString(daytwoPos)
            val checktwo = cursor.getInt(checktwoPos)
            val daythree = cursor.getString(daythreePos)
            val checkthree = cursor.getInt(checkthreePos)
            val dayfour = cursor.getString(dayfourPos)
            val checkfour = cursor.getInt(checkfourPos)
            val dayfive = cursor.getString(dayfivePos)
            val checkfive = cursor.getInt(checkfivePos)

            weeks.add(FiveDayWeeklyProgram(id, dayone, checkone, daytwo, checktwo, daythree, checkthree, dayfour, checkfour, dayfive, checkfive))
        }

        /* Close cursor */
        cursor.close()

        return weeks
    }
}