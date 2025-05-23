package com.example.lostpaws

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(private val pets: List<Pet>) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    class PetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView = view.findViewById(R.id.pet_image)
        val petName: TextView = view.findViewById(R.id.pet_name)
        val petType: TextView = view.findViewById(R.id.pet_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = pets[position]
        holder.petImage.setImageResource(pet.imageRes)
        holder.petName.text = pet.name
        holder.petType.text = pet.type
    }

    override fun getItemCount(): Int = pets.size
}