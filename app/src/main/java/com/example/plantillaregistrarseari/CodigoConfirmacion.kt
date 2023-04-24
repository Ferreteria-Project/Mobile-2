package com.example.plantillaregistrarseari

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

lateinit var BackCC:Button
lateinit var SiguienteCC: Button


class CodigoConfirmacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //Fijar teclado
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_confirmacion)
        val editText = findViewById<EditText>(R.id.txtCodigoCC)
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        //Bloquear Rotacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //btn back
        BackCC = findViewById(R.id.btnBackCC)
        BackCC.setOnClickListener {
            val openD: Intent = Intent(this, Mail::class.java)
            startActivity(openD)
        }

        //Btn siguiente
        SiguienteCC = findViewById(R.id.btnSiguienteCC)
        SiguienteCC.setOnClickListener {
            val openD: Intent = Intent(this, Credenciales::class.java)
            startActivity(openD)
        }
    }
}