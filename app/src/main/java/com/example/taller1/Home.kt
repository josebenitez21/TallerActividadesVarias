package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegarFormulario()
        navegarImagen()
        navegarGPS()
        navegarRow()
        navegarColumn()
        navegarRowColumn()
        navegarCamara()
        navegarPodometro()
    }

    fun navegarFormulario() {
        val btnFor = findViewById<Button>(R.id.btn_formulario)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Formulario::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarImagen() {
        val btnFor = findViewById<Button>(R.id.btn_imagen)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Imagen::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarGPS() {
        val btnFor = findViewById<Button>(R.id.btn_gps)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, location::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarRow() {
        val btnFor = findViewById<Button>(R.id.btn_rows)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Rows::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarColumn() {
        val btnFor = findViewById<Button>(R.id.btn_Colums)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Colums::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarRowColumn() {
        val btnFor = findViewById<Button>(R.id.btn_rowsColums)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, RowsColums::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarCamara() {
        val btnFor = findViewById<Button>(R.id.btn_camara)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Camara::class.java)
            startActivity(saltarVentana)
        }
    }

    fun navegarPodometro() {
        val btnFor = findViewById<Button>(R.id.btn_podometro)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Podometro::class.java)
            startActivity(saltarVentana)
        }
    }

}
