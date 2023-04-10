package com.example.discoveryempapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Info : Fragment() {
  //  private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =   inflater.inflate(R.layout.fragment_info, container, false)
        val intent = Intent(activity,Getinfo::class.java)

        activity?.startActivity(intent)

        return v
        // Inflate the layout for this fragment
/*
      val v =   inflater.inflate(R.layout.fragment_info, container, false)
        button = v.findViewById(R.id.EditB)
        button.setOnClickListener()
        {
        val intent = Intent(activity,Editinfo::class.java)

            activity?.startActivity(intent)

        }

return v*/
    }


    }
