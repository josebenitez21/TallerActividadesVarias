package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegarHome()
        layoutform()
    }

    fun navegarHome() {
        val btnFor = findViewById<Button>(R.id.btnReg1)

        btnFor.setOnClickListener() {
            val saltarVentana: Intent = Intent(this, Home::class.java)
            startActivity(saltarVentana)
        }
    }

    fun layoutform() {
        val btn_guardar = findViewById<Button>(R.id.btnguardar)
        val tv_nombre = findViewById<TextView>(R.id.txt_nombre)
        val tv_apellido = findViewById<TextView>(R.id.txt_apellido)
        val tv_correo = findViewById<TextView>(R.id.txt_correo)
        val tv_telefono = findViewById<TextView>(R.id.txt_telefono)
        val tv_direccion = findViewById<TextView>(R.id.txt_direccion)

        btn_guardar.setOnClickListener() {
            //val message = "Este es un mensaje"
            val message = "Nombre: ${tv_nombre.text}, Es estudiante\n" +
                    "Apellido: ${tv_apellido.text}, Apellido\n" +
                    "Correo: ${tv_correo.text}, Correo\n" +
                    "Telefono: ${tv_telefono.text}, Telefono\n" +
                    "Direccion: ${tv_direccion.text}, Direccion\n"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }


}