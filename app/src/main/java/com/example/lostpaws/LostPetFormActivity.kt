import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class LostPetFormActivity : AppCompatActivity() {

    private lateinit var petNameEditText: EditText
    private lateinit var petAgeEditText: EditText
    private lateinit var petBreedEditText: EditText
    private lateinit var petTypeSpinner: Spinner
    private lateinit var petLocationEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_pet_form)

        // Inicializar vistas
        petNameEditText = findViewById(R.id.pet_name)
        petAgeEditText = findViewById(R.id.pet_age)
        petBreedEditText = findViewById(R.id.pet_breed)
        petTypeSpinner = findViewById(R.id.pet_type)
        petLocationEditText = findViewById(R.id.pet_location)
        submitButton = findViewById(R.id.submit_button)

        // Configurar spinner para tipo de mascota
        val petTypes = arrayOf("Dog", "Cat", "Other")
        val petTypeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, petTypes)
        petTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        petTypeSpinner.adapter = petTypeAdapter

        // Configurar el botón de envío
        submitButton.setOnClickListener {
            val petName = petNameEditText.text.toString()
            val petAge = petAgeEditText.text.toString()
            val petBreed = petBreedEditText.text.toString()
            val petType = petTypeSpinner.selectedItem.toString()
            val petLocation = petLocationEditText.text.toString()

            // Aquí puedes manejar la lógica para guardar la información o enviarla al backend
            // Mostrar un mensaje, guardar la información, etc.
        }
    }
}
