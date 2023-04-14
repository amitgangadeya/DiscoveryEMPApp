package com.example.discoveryempapp

import android.content.Intent
import android.net.Uri
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
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/discoveryemployeeapp.appspot.com/o/khawas-2018-ijca-917200.pdf?alt=media&token=f697a87a-ef28-41a0-8dbc-8ce01cedf95b")))
        }
        team.setOnClickListener(){

        }


    }
}