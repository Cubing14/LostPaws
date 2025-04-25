package com.example.lostpaws

import LostPetFormActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a las vistas
        val dogButton: LinearLayout = findViewById(R.id.category_dog)
        val catButton: LinearLayout = findViewById(R.id.category_cat)
        val othersButton: LinearLayout = findViewById(R.id.category_others)
        val categoryText: TextView = findViewById(R.id.categories_title)

        val dogIcon: ImageView = findViewById(R.id.dog_icon)
        val catIcon: ImageView = findViewById(R.id.cat_icon)
        val othersIcon: ImageView = findViewById(R.id.others_icon)

        val lostPetButton: Button = findViewById(R.id.btn_lost_pet)

        // Establecer "Dogs" como texto por defecto
        categoryText.text = "Categories"

        // Establecer el borde por defecto
        dogIcon.setBackgroundResource(R.drawable.icon_border_selected)
        catIcon.setBackgroundResource(R.drawable.icon_border_default)
        othersIcon.setBackgroundResource(R.drawable.icon_border_default)

        // Establecer el texto de la categoría cuando se hace clic en "Dog"
        dogButton.setOnClickListener {
            categoryText.text = "Dogs"
            dogIcon.setBackgroundResource(R.drawable.icon_border_selected)
            catIcon.setBackgroundResource(R.drawable.icon_border_default)
            othersIcon.setBackgroundResource(R.drawable.icon_border_default)
        }

        // Establecer el texto de la categoría cuando se hace clic en "Cat"
        catButton.setOnClickListener {
            categoryText.text = "Cats"
            dogIcon.setBackgroundResource(R.drawable.icon_border_default)
            catIcon.setBackgroundResource(R.drawable.icon_border_selected)
            othersIcon.setBackgroundResource(R.drawable.icon_border_default)
        }

        // Establecer el texto de la categoría cuando se hace clic en "Others"
        othersButton.setOnClickListener {
            categoryText.text = "Others"
            dogIcon.setBackgroundResource(R.drawable.icon_border_default)
            catIcon.setBackgroundResource(R.drawable.icon_border_default)
            othersIcon.setBackgroundResource(R.drawable.icon_border_selected)
        }

        // Manejo de clic en "Lost your pet?" (botón)
        lostPetButton.setOnClickListener {
            val intent = Intent(this, LostPetFormActivity::class.java)
            startActivity(intent)
        }
    }
}
