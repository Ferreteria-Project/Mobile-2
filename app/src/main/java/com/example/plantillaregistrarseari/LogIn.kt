package com.example.plantillaregistrarseari

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogIn : AppCompatActivity() {

    lateinit var btres:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btres = findViewById(R.id.btnRegistrarseL)

        btres.setOnClickListener{
            val open: Intent = Intent (this, DatosPersonales::class.java)
            startActivity(open)
        }

    }
}