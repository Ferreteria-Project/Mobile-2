package com.example.plantillaregistrarseari

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ViewFlipper

class Pantalla_principal_cliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal_cliente)

        val viewFlipper: ViewFlipper = findViewById(R.id.viewFlipper)
        viewFlipper.setInAnimation(this, android.R.anim.fade_in)
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out)
        viewFlipper.flipInterval = 3000
        viewFlipper.isAutoStart = true

    }
}