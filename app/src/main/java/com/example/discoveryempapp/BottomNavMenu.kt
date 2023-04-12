package com.example.discoveryempapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.discoveryempapp.databinding.ActivityBottomNavMenuBinding

class BottomNavMenu : AppCompatActivity() {
    private lateinit var binding:ActivityBottomNavMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botnavmenu.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.dashboard -> showdashboard()
                R.id.info -> showinfo()
                R.id.office -> showoffice()
           else ->{

           }

        }
true
        }
    }
    private fun showoffice() {
        val intent = Intent(this, MyOffice::class.java)
        startActivity(intent)

    }
    private fun showdashboard() {
        val intent = Intent(this, Mydashboard::class.java)
        startActivity(intent)

    }

    private fun showinfo() {
        val intent = Intent(this, Getinfo::class.java)
        startActivity(intent)
    }




}