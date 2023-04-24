package com.example.plantillaregistrarseari

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Fotof:de.hdodenhof.circleimageview.CircleImageView
lateinit var BagregarF:Button

class FotoPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto_perfil)

        //Bloquear Rotacion
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //Boton Back
        backC = findViewById(R.id.btnBackF)
        backC.setOnClickListener {
            val openC: Intent = Intent(this, Credenciales::class.java)
            startActivity(openC)
        }

        //Subir foto
        Fotof = findViewById(R.id.imgf)
        BagregarF = findViewById(R.id.btnAgregarF)

        BagregarF.setOnClickListener {
            pickImage()
        }
    }

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var imageUri: Uri

    private fun pickImage() {
        // Crea un intent para abrir la galería y seleccionar una imagen
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Verifica que el resultado sea para la solicitud de imagen y que el usuario haya seleccionado una imagen
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            // Obtén la URI de la imagen seleccionada
            imageUri = data.data!!

            // Muestra la imagen en el ImageView
            Fotof.setImageURI(imageUri)
        }
    }




}