 package com.example.discoveryempapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 class SystemsOfEngagement : AppCompatActivity() {
     private lateinit var ob :Button
    private lateinit var proj:Button
     private lateinit var tem:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_systems_of_engagement)
        ob = findViewById(R.id.onboard)
        proj = findViewById(R.id.projects)
        tem = findViewById(R.id.teaminfo)
            ob.setOnClickListener(){
            val intent = Intent(this,MyOnboarding::class.java )
            startActivity(intent)
        }

        proj.setOnClickListener(){
            val intent = Intent(this,Projects::class.java )
            startActivity(intent)
        }

        tem.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/discoveryemployeeapp.appspot.com/o/tree-diagrams-pdf.pdf?alt=media&token=9fe36732-d915-4044-b4dc-66d81aee3ff2")))
        }
        /*
       resources.setOnClickListener(){
           val intent = Intent(this,Resources::class.java )
       }*/

    }
}