package com.example.discoveryempapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Emailsetup : AppCompatActivity() {
    private lateinit var pdfb:Button
    private lateinit var spdfb:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emailsetup)


        spdfb = findViewById(R.id.shpdf)

        spdfb.setOnClickListener(){

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/discoveryemployeeapp.appspot.com/o/Rajagukguk_2018_J._Phys.__Conf._Ser._1120_012020.pdf?alt=media&token=df376461-2336-4414-8f74-75e2776b546c")))
            }
        }
    }
