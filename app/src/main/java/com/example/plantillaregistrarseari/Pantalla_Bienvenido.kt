package com.example.plantillaregistrarseari

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button

lateinit var Siguiente: Button


class Pantalla_Bienvenido : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.splashcreen);

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_bienvenido)

        Siguiente = findViewById(R.id.btnSiguienteM3)
        Siguiente.setOnClickListener {
            val openD: Intent = Intent(this, DatosPersonales::class.java)
            startActivity(openD)

    }
}
}