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
import java.security.MessageDigest
import java.nio.charset.StandardCharsets

lateinit var backC:Button
lateinit var SiguienteC:Button
lateinit var TUserC:EditText
lateinit var TPassC:EditText
lateinit var TPass2C:EditText

class Credenciales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credenciales)

        //Fijar teclado
        val editText = findViewById<EditText>(R.id.txtUsernameC)
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        //Bloquear Rotacion
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //Boton Back
        backC = findViewById(R.id.btnBackC)
        backC.setOnClickListener {
            val openC: Intent = Intent(this, DatosPersonales::class.java)
            startActivity(openC)
        }

        //Boton Siguiente
        SiguienteC = findViewById(R.id.btnSiguienteC)
        SiguienteC.setOnClickListener {
            //Validaciones
            TUserC = findViewById(R.id.txtUsernameC)
            TPassC = findViewById(R.id.txtPasswordC)
            TPass2C = findViewById(R.id.txtPassword2C)

            val passC = TPassC.text.toString()
            val pass2C = TPass2C.text.toString()

            //Encriptar contraseña

            println(passC)
            println(pass2C)

            val encryptedPasswordC = encrypt(passC)
            val encryptedPassword2C = encrypt(pass2C)

            println(encryptedPasswordC)
            println(encryptedPassword2C)

            if (TUserC.text.isEmpty()) {
                TUserC.error = "Ingrese un nombre de Usuario"
            } else if (TPassC.text.isEmpty()) {
                TPassC.error = "Ingrese una contraseña"
            } else if (TPass2C.text.isEmpty()) {
                TPass2C.error = "Por favor confirme su contraseña"
            } else if (encryptedPasswordC != encryptedPassword2C) {
                TPass2C.error = "Las contraseñas ingresadas no coinciden"
            } else {
                val open: Intent = Intent(this, Mail::class.java)
                startActivity(open)
            }
        }
    }

    //Funcion para encriptar contraseñas
    fun encrypt(password: String): String {
        val bytes = password.toByteArray(StandardCharsets.UTF_8)
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }


}