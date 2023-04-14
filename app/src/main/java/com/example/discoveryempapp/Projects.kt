package com.example.discoveryempapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Projects : AppCompatActivity() {
    private lateinit var p1 : Button
    private lateinit var p2: Button
    private lateinit var p3: Button
    private lateinit var p4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        p1= findViewById(R.id.project1)
        p2= findViewById(R.id.project2)


        p1.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/discoveryemployeeapp.appspot.com/o/pink-noise_2001.pdf?alt=media&token=d2c940aa-dd31-4e20-8c26-ced8c27ad7a6")))
        }
        p2.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/discoveryemployeeapp.appspot.com/o/pankajatgfirebase.pdf?alt=media&token=fd726fa5-d0d3-4bb9-a4d2-7ea9c7335d29")))
        }





    }
}