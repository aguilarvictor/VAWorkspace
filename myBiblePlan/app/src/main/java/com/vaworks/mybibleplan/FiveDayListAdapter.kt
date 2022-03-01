package com.vaworks.mybibleplan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class FiveDayListAdapter (
    private val context: Context
    ): RecyclerView.Adapter<FiveDayListAdapter.WeekViewHolder>() {

    lateinit var weekList : ArrayList<FiveDayWeeklyProgram>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return WeekViewHolder(context, itemView)
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        val week = weekList[position]
        holder.setData(
            week.id,
            week.dayone,
            week.checkone,
            week.daytwo,
            week.checktwo,
            week.daythree,
            week.checkthree,
            week.dayfour,
            week.checkfour,
            week.dayfive,
            week.checkfive
        )
    }

    override fun getItemCount(): Int = weekList.size

    class WeekViewHolder(private val context: Context, itemView: View): RecyclerView.ViewHolder(itemView) {

        fun setData(id: Int, dayone: String, checkone: Int, daytwo: String, checktwo: Int,
                    daythree: String, checkthree: Int, dayfour: String, checkfour: Int,
                    dayfive: String, checkfive: Int
        ) {

            val weekno = this.context.getString(R.string.week_no, id)
            itemView.week_text.text = weekno
            itemView.day1_check.text = dayone
            itemView.day1_check.isChecked = checkone.toBoolean()
            itemView.day2_check.text = daytwo
            itemView.day2_check.isChecked = checktwo.toBoolean()
            itemView.day3_check.text = daythree
            itemView.day3_check.isChecked = checkthree.toBoolean()
            itemView.day4_check.text = dayfour
            itemView.day4_check.isChecked = checkfour.toBoolean()
            itemView.day5_check.text = dayfive
            itemView.day5_check.isChecked = checkfive.toBoolean()
        }

        private fun Int.toBoolean(): Boolean {
            return this == 1
        }

    }

}