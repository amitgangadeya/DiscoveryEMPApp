package com.example.discoveryempapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

 class MyOffice : AppCompatActivity() {
     private lateinit var makepdf: Button
     private lateinit var viewpdf: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_office)
        makepdf = findViewById(R.id.MakePDF)
        viewpdf = findViewById(R.id.viewdoc)
        viewpdf.setOnClickListener()
        {
            val intent = Intent(
                this,
                OpenPDF::class.java
            )
            startActivity(intent)
        }
        makepdf.setOnClickListener(){
            val intent = Intent(
                this,
                MakeApdf::class.java
            )
            startActivity(intent)

        }
        title = "My Office"
        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
        val today = Calendar.getInstance()
       val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        val date = today.get(Calendar.DAY_OF_MONTH)
datePicker.init(year,month,date,null)
    }
    fun addCalendarEvent(view: View) {
        val calendarEvent: Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("beginTime", calendarEvent.timeInMillis)
        intent.putExtra("allDay", true)
        intent.putExtra("rule", "FREQ=YEARLY")
        intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
        intent.putExtra("title", "Calendar Event")
        startActivity(intent)
    }
}