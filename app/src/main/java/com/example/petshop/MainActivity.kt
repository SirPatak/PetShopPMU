package com.example.petshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petshop.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val database:DatabaseReference = FirebaseDatabase.getInstance("https://pet-shop-5e430-default-rtdb.europe-west1.firebasedatabase.app/").getReference("tekstovi")
    var tekst1 = ArrayList<tekst>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.unesi.setOnClickListener {
            val tempText=binding.text.text.toString()
            val tempOpis=binding.opis.text.toString()
            var tempId=0
            if(!tekst1.isEmpty()) tempId = tekst1[tekst1.size-1].id+1

            tekst1.add(tekst(tempId,tempOpis,tempText))

            database.setValue(tekst1)
        }

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                tekst1.clear()
                try {
                    val a:List<tekst> = snapshot.children.map{dataSnapshot ->  dataSnapshot.getValue(tekst::class.java)!!}
                    tekst1.addAll(a)
                }
                catch (e:Exception){}


                binding.RV.apply {
                    layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = textAdapter(tekst1, this@MainActivity)
                }

            }



            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })



    }
}