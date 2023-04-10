package com.example.discoveryempapp

import android.app.Dialog
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import com.example.discoveryempapp.databinding.ActivityGetinfoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class Getinfo : AppCompatActivity() {
    private lateinit var binding: ActivityGetinfoBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid: String
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getinfo)
       binding = ActivityGetinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()
        uid =auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        if(uid.isNotEmpty())
        {
            getUserData()
        }



        button = findViewById(R.id.EditB)
        button.setOnClickListener()
        {
            val intent = Intent(
                this,
                Editinfo::class.java
            )

            startActivity(intent)

        }
    }

    private fun getUserData()
    {
        showprogressbar()
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.getValue(User::class.java)!!
                binding.Nands.setText(user.fname)
                binding.ID.setText(user.idno)
                binding.Printercode.setText(user.pcode)
                binding.ETno.setText(user.etno)
                binding.Pos.setText(user.position)
                getUserProfile()

            }

            override fun onCancelled(error: DatabaseError) {
                hideprogressbar()
                Toast.makeText(this@Getinfo,"Failed",Toast.LENGTH_SHORT).show()

            }
        } )
    }

    private fun getUserProfile() {

        storageReference = FirebaseStorage.getInstance().reference.child("Users/$uid.jpg")
        val localfile = File.createTempFile("tempimage","jpg")
        storageReference.getFile(localfile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            binding.profileImage.setImageBitmap(bitmap)
            hideprogressbar()
        }.addOnFailureListener{
            hideprogressbar()
            Toast.makeText(this@Getinfo,"Failed",Toast.LENGTH_SHORT).show()
        }

    }
    private fun showprogressbar()
    {
        dialog = Dialog(this@Getinfo)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

    }
    private fun hideprogressbar()
    {
        dialog.dismiss()
    }
}