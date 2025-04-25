package com.example.lostpaws

import android.net.Uri

data class PetPost(
    val name: String,
    val age: String,
    val breed: String,
    val type: String,
    val location: String,
    val imageUri: Uri?
)
