package com.example.plantillaregistrarseari

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import java.util.*
import kotlin.properties.Delegates

lateinit var Tfecha: EditText
lateinit var Ttelefono: EditText
lateinit var siguienteD: Button
lateinit var Tnombre: EditText

var dia by Delegates.notNull<Int>()
var mes by Delegates.notNull<Int>()
var ano by Delegates.notNull<Int>()

class DatosPersonales : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)

        //Fijar teclado
        val editText = findViewById<EditText>(R.id.txtNombreD)
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        //Bloquear Rotacion
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //Agregar Fecha de nacimiento
        Tfecha = findViewById(R.id.txtFechaNacimientoD)
        Tfecha.setOnClickListener(this)

        //Codigo de pais en campo telefono
        Ttelefono = findViewById(R.id.txtTelefonoD)
        Ttelefono.setText("+503 ")

        //Boton siguiente
        Tnombre = findViewById(R.id.txtNombreD)
        siguienteD = findViewById(R.id.btnSiguienteD)
        siguienteD.setOnClickListener {

            if (Tnombre.text.isEmpty()) {
                Tnombre.error = "Ingrese su nombre completo."
            } else if (Tfecha.text.isEmpty()) {
                Tfecha.error = "Ingrese su fecha de nacimiento."
            } else if (Ttelefono.text.isEmpty()) {
                Ttelefono.error = "Ingrese su numero de telefono."
            } else if (Ttelefono.text.length != 13) {
                Ttelefono.error = "Ingrese un número de teléfono de 8 dígitos."
            } else {
                val fechaIngresada = Tfecha.text.toString()
                val fechaSeleccionada = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(fechaIngresada)
                val fechaActual = Date()
                val fechaMinima = GregorianCalendar(1900, Calendar.JANUARY, 1).time

                if (fechaSeleccionada.before(fechaMinima) || fechaSeleccionada.after(fechaActual)) {
                    Tfecha.error = "Ingrese una fecha de nacimiento válida."
                } else {
                    val openD: Intent = Intent(this, FotoPerfil::class.java)
                    startActivity(openD)
                }
            }
        }
    }

    override fun onClick(v: View) {
        if (v == Tfecha) {
            val c = Calendar.getInstance()
            dia = c.get(Calendar.DAY_OF_MONTH)
            mes = c.get(Calendar.MONTH)
            ano = c.get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    Tfecha.setText("$dayOfMonth/${month + 1}/$year")
                },
                dia,
                mes,
                ano
            )
            datePickerDialog.show()
        }
    }
}
