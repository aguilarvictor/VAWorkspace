package com.vaworks.mybibleplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vaworks.mybibleplan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fivedayPlanButton.setOnClickListener {
            val goToPlan = Intent(this, FiveDayActivity::class.java)
            startActivity(goToPlan)
        }
    }
}