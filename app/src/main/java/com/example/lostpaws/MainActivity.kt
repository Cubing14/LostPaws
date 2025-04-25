package com.example.lostpaws

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        // Establecer "Categories" como texto por defecto
        categoryText.text = "Categories"

        // Establecer el borde por defecto en los íconos
        dogIcon.setBackgroundResource(R.drawable.icon_border_selected)
        catIcon.setBackgroundResource(R.drawable.icon_border_default)
        othersIcon.setBackgroundResource(R.drawable.icon_border_default)

        // Clic en "Dog"
        dogButton.setOnClickListener {
            categoryText.text = "Dogs"
            updateCategoryIcons(dogIcon, catIcon, othersIcon)
        }

        // Clic en "Cat"
        catButton.setOnClickListener {
            categoryText.text = "Cats"
            updateCategoryIcons(catIcon, dogIcon, othersIcon)
        }

        // Clic en "Others"
        othersButton.setOnClickListener {
            categoryText.text = "Others"
            updateCategoryIcons(othersIcon, dogIcon, catIcon)
        }

        // Clic en "Lost your pet?"
        lostPetButton.setOnClickListener {
            val intent = Intent(this, LostPetFormActivity::class.java)
            startActivity(intent)
        }
    }

    // Función auxiliar para actualizar los íconos de las categorías
    private fun updateCategoryIcons(selected: ImageView, vararg others: ImageView) {
        selected.setBackgroundResource(R.drawable.icon_border_selected)
        others.forEach { it.setBackgroundResource(R.drawable.icon_border_default) }
    }
}
