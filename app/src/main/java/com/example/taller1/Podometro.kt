package com.example.taller1

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Podometro : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var stepCounterSensor: Sensor? = null
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_podometro)

        // Inicializa el SensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        // Verifica y solicita permisos en tiempo de ejecución
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val PERMISSION_REQUEST_ACTIVITY_RECOGNITION = 100
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACTIVITY_RECOGNITION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                    PERMISSION_REQUEST_ACTIVITY_RECOGNITION
                )
            }
        }

        if (stepCounterSensor == null) {
            println("El sensor de pasos no está disponible en este dispositivo")
        }

        // Configura los botones
        val startButton = findViewById<Button>(R.id.btn_empezar)
        val stopButton = findViewById<Button>(R.id.btn_detener)

        startButton.setOnClickListener {
            // Registra el sensor para comenzar a rastrear pasos
            stepCounterSensor?.also { sensor ->
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
            }
        }

        stopButton.setOnClickListener {
            // Detiene el sensor y reinicia los pasos a 0
            sensorManager.unregisterListener(this)
            totalSteps = 0f
            previousTotalSteps = 0f

            // Actualiza el TextView para mostrar 0 pasos
            val stepsTextView = findViewById<TextView>(R.id.txt_pasos)
            stepsTextView.text = String.format("%.2f", totalSteps)
        }
    }

    override fun onResume() {
        super.onResume()
        stepCounterSensor?.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_STEP_COUNTER) {
            if (previousTotalSteps == 0f) {
                previousTotalSteps = event.values[0]
            }
            val currentSteps = event.values[0] - previousTotalSteps
            totalSteps = currentSteps

            // Actualiza el TextView dinámicamente
            val stepsTextView = findViewById<TextView>(R.id.txt_pasos)
            stepsTextView.text = String.format("%.2f", totalSteps)

        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}