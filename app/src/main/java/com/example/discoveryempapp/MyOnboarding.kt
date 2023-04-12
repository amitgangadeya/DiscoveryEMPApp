package com.example.discoveryempapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyOnboarding : AppCompatActivity() {
    private lateinit var email :Button
    private lateinit var enviro:Button
    private lateinit var team:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_onboarding)
        email = findViewById(R.id.emal)
        enviro = findViewById(R.id.env)
        team =  findViewById(com.example.discoveryempapp.R.id.axess)
        email.setOnClickListener(){
            val intent = Intent(this, Emailsetup::class.java)
            startActivity(intent)
        }
        enviro.setOnClickListener(){
            val intent = Intent(this, Projects::class.java)
        }
        team.setOnClickListener(){
            val intent = Intent(this, TeamInfo::class.java)
        }


    }
}