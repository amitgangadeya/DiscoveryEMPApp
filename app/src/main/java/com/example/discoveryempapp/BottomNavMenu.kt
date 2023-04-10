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
                R.id.office -> repfrag(Office())
           else ->{

           }

        }
true
        }
    }

    private fun showdashboard() {
        val intent = Intent(this, Mydashboard::class.java)
        startActivity(intent)

    }

    private fun showinfo() {
        val intent = Intent(this, Getinfo::class.java)
        startActivity(intent)
    }

    private fun repfrag(fragment:Fragment)
    {
        val fragman = supportFragmentManager
        val fragmenttrans = fragman.beginTransaction()
        fragmenttrans.replace(R.id.frame,fragment)
        fragmenttrans.commit()
    }


}