package com.example.lostpaws

import android.widget.Toast
import android.util.Log

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Botón Sign Up
        val signUpButton: Button = findViewById(R.id.btnSignUp)
        signUpButton.setOnClickListener {
            // Aquí va la lógica de registro. Si el registro es exitoso, se redirige al LoginActivity
            // Lógica de registro, por ahora solo redirige al LoginActivity
            val intent = Intent(this, MainActivity::class.java) // Redirigir al MainActivity
            startActivity(intent)
            finish()  // Cerrar SignUpActivity
        }

        val tvHaveAccount: TextView = findViewById(R.id.tvHaveAccount)
        tvHaveAccount.setOnClickListener {
            Log.d("SignupActivity", "Clic en 'Already have an account?'")
            Toast.makeText(this, "Clic detectado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}
