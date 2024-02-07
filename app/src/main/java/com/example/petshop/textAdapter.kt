package com.example.petshop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.petshop.databinding.ActivityMainBinding
import com.example.petshop.databinding.VlasnikZivotinjeBinding

class textAdapter(
    private val textList: ArrayList<tekst>,
    private val th: Context

): RecyclerView.Adapter<textAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): textAdapter.ViewHolder {
        val v = VlasnikZivotinjeBinding.inflate(LayoutInflater.from(th), parent, false)
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
                fun bindItem(tekst: tekst, th: Context) {
                    itemBinding.id.text=tekst.id.toString()
                    itemBinding.text.text=tekst.text
                    itemBinding.opis.text=tekst.opis
                }
            }
}