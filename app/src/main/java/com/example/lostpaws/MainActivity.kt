package com.example.lostpaws

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lostPetButton: Button = findViewById(R.id.btn_lost_pet)

        // Lista de mascotas por defecto
        val pets = listOf(
            Pet("Buddy", "Dog", R.drawable.ic_dog),
            Pet("Mittens", "Cat", R.drawable.ic_cat),
            Pet("Charlie", "Dog", R.drawable.ic_dog),
            Pet("Whiskers", "Cat", R.drawable.ic_cat)
        )

        // Configurar RecyclerView
        val recyclerPets: RecyclerView = findViewById(R.id.recycler_pets)
        recyclerPets.layoutManager = LinearLayoutManager(this)
        recyclerPets.adapter = PetAdapter(pets)

        // Clic en "Lost your pet?"
        lostPetButton.setOnClickListener {
            val intent = Intent(this, LostPetFormActivity::class.java)
            startActivity(intent)
        }
    }
}