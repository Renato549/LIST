package com.example.listproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var superheros:MutableList<Superhero> = ArrayList()
    lateinit var context: Context


    fun RecyclerAdapter(superheros:MutableList<Superhero>,context: Context){
        this.superheros = superheros
        this.context = context
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero_list,parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val superHeroName = view.findViewById(R.id.tvSuperhero) as TextView
        val realName = view.findViewById<TextView>(R.id.tvRealName)
        val publisher = view.findViewById(R.id.tvPublisher) as TextView
        val avatar = view.findViewById(R.id.ivAvatar)as ImageView

        fun bind(item:Superhero,context: Context){
            superHeroName.text = item.superhero
            realName.text = item.realName
            publisher.text = item.publisher

            itemView.setOnClickListener{
                Toast.makeText(context,item.superhero,Toast.LENGTH_SHORT).show()
            }

            Picasso.get().load(item.photo).into(avatar)

        }

    }
}