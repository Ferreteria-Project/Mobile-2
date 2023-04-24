package com.example.plantillaregistrarseari

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

lateinit var TmailM:EditText
lateinit var SiguienteM:Button
lateinit var BackM:Button


class Mail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //Fijar teclado
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)
        val editText = findViewById<EditText>(R.id.txtMailM)
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        //Bloquear Rotacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //Boton Back
        BackM = findViewById(R.id.btnBackM)
        BackM.setOnClickListener {
            val openD: Intent = Intent(this, DatosPersonales::class.java)
            startActivity(openD)
        }

        //Boton Siguiente
        SiguienteM = findViewById(R.id.btnSiguienteM)
        TmailM = findViewById(R.id.txtMailM)
        SiguienteM.setOnClickListener {
            if (TmailM.text.isEmpty()) {
                TmailM.error = "Ingresa tu correo electronico"
            } else {
                if (validarEmail(TmailM.text.toString())) {
                    val openD: Intent = Intent(this, CodigoConfirmacion::class.java)
                    startActivity(openD)
                } else {
                    TmailM.error = "Ingrese un correo electronico valido"
                }
            }
        }

    }

    //Funcion para validar correo
    fun validarEmail(email: String): Boolean {
        // Expresión regular para validar el formato de correo electrónico
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

        // Verificar si el correo electrónico cumple con el formato esperado
        return email.matches(pattern)
    }

    //funcion para enviar correo



}