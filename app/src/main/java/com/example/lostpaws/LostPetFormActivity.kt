package com.example.lostpaws

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LostPetFormActivity : AppCompatActivity() {

    private lateinit var petNameEditText: EditText
    private lateinit var petAgeEditText: EditText
    private lateinit var petBreedEditText: EditText
    private lateinit var petTypeSpinner: Spinner
    private lateinit var petLocationEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var uploadPhotoButton: Button
    private lateinit var petImageView: ImageView

    private var imageUri: Uri? = null

    // Lista global para almacenar las publicaciones
    companion object {
        val petPosts = ArrayList<PetPost>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_pet_form)

        petNameEditText = findViewById(R.id.pet_name)
        petAgeEditText = findViewById(R.id.pet_age)
        petBreedEditText = findViewById(R.id.pet_breed)
        petTypeSpinner = findViewById(R.id.pet_type)
        petLocationEditText = findViewById(R.id.pet_location)
        submitButton = findViewById(R.id.submit_button)
        uploadPhotoButton = findViewById(R.id.upload_photo_button)
        petImageView = findViewById(R.id.pet_image_view)

        // Configurar el spinner para el tipo de mascota
        val petTypes = arrayOf("Dog", "Cat", "Other")
        val petTypeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, petTypes)
        petTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        petTypeSpinner.adapter = petTypeAdapter

        // Configurar el botón para elegir la foto
        uploadPhotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }

        // Configurar el botón de enviar
        submitButton.setOnClickListener {
            val petName = petNameEditText.text.toString()
            val petAge = petAgeEditText.text.toString()
            val petBreed = petBreedEditText.text.toString()
            val petType = petTypeSpinner.selectedItem.toString()
            val petLocation = petLocationEditText.text.toString()

            val closeButton: ImageView = findViewById(R.id.btn_close)

// Cerrar la actividad al hacer clic en la "X"
            closeButton.setOnClickListener {
                finish() // Vuelve a la pantalla anterior
            }

            // Crear una nueva publicación
            val petPost = PetPost(petName, petAge, petBreed, petType, petLocation, imageUri)

            // Guardar la publicación en la lista
            petPosts.add(petPost)

            // Notificar al usuario
            Toast.makeText(this, "Publication added!", Toast.LENGTH_SHORT).show()

            // Volver al menú de navegación (por ejemplo)
            finish()
        }
    }

    // Manejo de la selección de imagen
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            imageUri = data?.data
            petImageView.setImageURI(imageUri)
        }
    }


}
