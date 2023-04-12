 package com.example.discoveryempapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 class SystemsOfEngagement : AppCompatActivity() {
     private lateinit var onboard :Button
     private lateinit var projects:Button
     private lateinit var teamin:Button
     private lateinit var resources:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_systems_of_engagement)
        onboard = findViewById(R.id.onboard)
            onboard.setOnClickListener(){
            val intent = Intent(this,MyOnboarding::class.java )
            startActivity(intent)
        }
        /*
        projects.setOnClickListener(){
            val intent = Intent(this,Projects::class.java )
        }
        teamin.setOnClickListener(){
            val intent = Intent(this,TeamInfo::class.java )
        }
        resources.setOnClickListener(){
            val intent = Intent(this,Resources::class.java )
        }*/

    }
}