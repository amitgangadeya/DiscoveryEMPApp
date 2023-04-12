package com.example.discoveryempapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Mydashboard : AppCompatActivity() {
    private lateinit var soe : Button
    /*  implement later if i have time
    private lateinit var vitality: Button
    private lateinit var insure: Button
    private lateinit var invest: Button
    private lateinit var health: Button
    private lateinit var life: Button
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mydashboard)
        soe = findViewById(R.id.soee)

    soe.setOnClickListener(){
        val intent = Intent(this,
            SystemsOfEngagement::class.java)
        startActivity(intent)
    }



    }
}