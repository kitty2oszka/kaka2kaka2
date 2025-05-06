package com.example.oszkacalculus

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel


class MainActivity : AppCompatActivity() {

    lateinit var tytul: TextView
    lateinit var prowizja: TextView
    lateinit var oprocentowanie: TextView
    lateinit var kwota: TextView
    lateinit var switch1: TextView
    lateinit var seekBar: SeekBar
    lateinit var seekBar2: SeekBar
    lateinit var android: ImageButton
    lateinit var chce: TextView
    lateinit var inputprowizja: TextView
    lateinit var inputkredyt: TextView
    lateinit var iledni: TextView
    lateinit var dni90: TextView
    lateinit var kwota100: TextView
    lateinit var kwota6000: TextView
    lateinit var dni1: TextView
    lateinit var blank: View
    lateinit var resultTextView: TextView
    lateinit var switchFixedRate: SwitchCompat

    override fun onCreate(savedInstances: Bundle?) {
        super.onCreate(savedInstances)
        setContentView(R.layout.activity_main)

        tytul = findViewById(R.id.tytul)
        prowizja = findViewById(R.id.prowizja)
        oprocentowanie = findViewById(R.id.oprocentowanie)
        kwota = findViewById(R.id.kwota)
        switch1 = findViewById(R.id.switch1)
        seekBar = findViewById(R.id.seekBar)
        seekBar2 = findViewById(R.id.seekBar2)
        android = findViewById(R.id.android)
        chce = findViewById(R.id.chce)
        inputprowizja = findViewById(R.id.inputprowizja)
        inputkredyt = findViewById(R.id.inputkredyt)
        iledni = findViewById(R.id.iledni)
        dni90 = findViewById(R.id.dni90)
        kwota100 = findViewById(R.id.kwota100)
        kwota6000 = findViewById(R.id.kwota6000)
        dni1 = findViewById(R.id.dni1)
        blank = findViewById(R.id.blank)
        resultTextView = findViewById(R.id.resultTextView)
        switchFixedRate = findViewById(R.id.switchFixedRate)

        seekBar.max = 60 // Set maximum to 6000 (scaling factor: 100)
        seekBar2.max = 90

        // Synchronize SeekBar and input fields
        inputkredyt.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val inputAmount = inputkredyt.text.toString().toIntOrNull() ?: 0
                seekBar.progress = inputAmount / 100 // Example scaling factor
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                inputkredyt.text = (progress * 100).toString() // Example scaling factor
                updateResults()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        inputprowizja.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val inputDays = inputprowizja.text.toString().toIntOrNull() ?: 0
                seekBar2.progress = inputDays
            }
        }

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                inputprowizja.text = progress.toString()
                updateResults()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set Switch listener
        switchFixedRate.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Fixed rate enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Fixed rate disabled", Toast.LENGTH_SHORT).show()
            }
            updateResults()
        }

        // Initial calculation
        updateResults()
    }

    private fun updateResults() {
        val loanAmount = seekBar.progress * 100 // Example scaling factor
        val days = seekBar2.progress
        val rate = 0.05 // Example interest rate (5%)
        val yearDays = 365

        val interest = if (switchFixedRate.isChecked) {
            loanAmount * rate * days / yearDays
        } else {
            0.0 // Placeholder for other calculation modes
        }

        val rrso = interest / loanAmount * 100 // Example RRSO calculation

        resultTextView.text = "Kwota kredytu: $loanAmount PLN\n" +
                "Ilosc dni: $days\n" +
                "Marza: ${loanAmount * 0.01} PLN\n" + // Example margin (1% of loan amount)
                "Odsetki: ${"%.2f".format(interest)} PLN\n" +
                "RRSO: ${"%.2f".format(rrso)}%"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)


    }


}