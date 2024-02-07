package com.example.petshop

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petshop.databinding.ActivityUrediVlasnikaBinding
import com.example.petshop.Vlasnik
import com.example.petshop.databinding.VlasnikZivotinjeBinding

class UrediVlasnika : AppCompatActivity() {

    lateinit var binding:ActivityUrediVlasnikaBinding
    lateinit var currentVlasnik: Vlasnik
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uredi_vlasnika)

        binding = ActivityUrediVlasnikaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val position = intent.getIntExtra("pos",0)

        currentVlasnik= Vlasnik.Vlasnik[position]



        var a="Detalji:\n"
        a+= "\nIme: ${currentVlasnik.ime}\nPrezime: ${currentVlasnik.prezime}\n OIB: ${currentVlasnik.oib}\n" +
                " mail: ${currentVlasnik.mail}\n adresa : ${currentVlasnik.adresa} \n "
    }
}

class textAdapter(
    private val textList: ArrayList<Vlasnik>,
    private val th: Context

): RecyclerView.Adapter<textAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): textAdapter.ViewHolder {
        val v = ActivityUrediVlasnikaBinding.inflate(LayoutInflater.from(th), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: textAdapter.ViewHolder, position: Int) {
        holder.bindItem(textList[position], th)
    }

    override fun getItemCount(): Int {
        return textList.size
    }

    class ViewHolder(private var itemBinding: VlasnikZivotinjeBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(Vlasnik: Vlasnik, th: Context) {
            itemBinding.id.text=tekst.id.toString()
            itemBinding.ime.text=tekst.ime
            itemBinding.prezime.text=tekst.prezime
            itemBinding.opis.text=tekst.opis
        }
    }
}