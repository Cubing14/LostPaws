package com.example.lostpaws

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Configurar el botón Log In
        val btnLogIn = findViewById<Button>(R.id.btnLogIn)
        btnLogIn.setOnClickListener {
            // Crear la intención para ir a la actividad principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Cerrar LoginActivity para evitar que el usuario regrese a ella con el botón de retroceso
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
