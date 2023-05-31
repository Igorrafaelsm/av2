package com.example.myapplication.view.FormCadastro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class UsAdapter(private val empList: ArrayList<UsuarioModelo>) :
    RecyclerView.Adapter<UsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.us_listar_intem, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.usName.text = currentEmp.usNome
    }

    override fun getItemCount(): Int {
        return empList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val usName : TextView = itemView.findViewById(R.id.etNome)


    }
}
