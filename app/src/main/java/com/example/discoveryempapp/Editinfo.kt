package com.example.discoveryempapp

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.discoveryempapp.databinding.ActivityEditinfoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Editinfo : AppCompatActivity() {
    private lateinit var binding: ActivityEditinfoBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()
        val uid =auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.Saveinfo.setOnClickListener {
            showprogressbar()
         val fsname = binding.namez.text.toString()
         val idno = binding.identity.text.toString()
            val entno = binding.entitynum.text.toString()
            val position =binding.position.text.toString()
         val printcode = binding.printcode.text.toString()
          val user = User(fsname,idno,entno,position,printcode)
            databaseReference.child(uid).setValue(user).addOnCompleteListener{
                if(it.isSuccessful){

                    uploadprofilepic()
                }else{
hideprogressbar()
                    Toast.makeText(this@Editinfo,"Failed", Toast.LENGTH_SHORT).show()
                }

            }

        }


    }



    private fun uploadprofilepic() {
       imageUri = Uri.parse("android.resource://$packageName/${R.drawable.disclogo}")
        storageReference= FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid+".jpg")
        storageReference.putFile(imageUri).addOnSuccessListener {
            hideprogressbar()
            Toast.makeText(this@Editinfo,"Success", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            hideprogressbar()
            Toast.makeText(this@Editinfo,"Failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showprogressbar()
    {
        dialog = Dialog(this@Editinfo)
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