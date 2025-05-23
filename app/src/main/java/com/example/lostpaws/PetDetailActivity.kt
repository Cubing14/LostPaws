package com.example.lostpaws

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)

        // Recuperar los datos enviados desde MainActivity
        val petName = intent.getStringExtra("EXTRA_PET_NAME")
        val petType = intent.getStringExtra("EXTRA_PET_TYPE")
        val petImage = intent.getIntExtra("EXTRA_PET_IMAGE", R.drawable.ic_dog)

        // Referencias a la vista
        val petImageView: ImageView = findViewById(R.id.pet_detail_image)
        val petNameView: TextView = findViewById(R.id.pet_detail_name)
        val petTypeView: TextView = findViewById(R.id.pet_detail_type)
        val closeButton: ImageView = findViewById(R.id.btn_close)

// Cerrar la actividad al hacer clic
        closeButton.setOnClickListener {
            finish() // Vuelve a la pantalla anterior
        }

        // Establecer los valores en la vista
        petImageView.setImageResource(petImage)
        petNameView.text = petName
        petTypeView.text = petType
    }
}