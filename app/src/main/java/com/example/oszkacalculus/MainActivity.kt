package com.example.oszkacalculus

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel


class MainActivity : AppCompatActivity() {

    lateinit var tytul: TextView
    lateinit var prowizja: TextView
    lateinit var oprocentowanie: TextView
    lateinit var kwota: TextView
    lateinit var switch1: TextView
    lateinit var seekBar: TextView
    lateinit var seekBar2: TextView
    lateinit var android: TextView
    lateinit var chce: TextView
    lateinit var inputprowizja: TextView
    lateinit var inputkredyt: TextView
    lateinit var iledni: TextView
    lateinit var dni90: TextView
    lateinit var kwota100: TextView
    lateinit var kwota6000: TextView
    lateinit var dni1: TextView
    lateinit var blank: TextView

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
            var txt = inputkredyt.text.toString()
            var txt2 = inputprowizja.text.toString()
            var txt3 = seekBar.text.toString()
            var txt4 = seekBar2.text.toString()
            var txt5 = iledni.text.toString()
            var txt6 = dni90.text.toString()
            var txt7 = kwota100.text.toString()
            var txt8 = kwota6000.text.toString()
            var txt9 = dni1.text.toString()
            var txt10 = blank.text.toString()
            var txt11 = tytul.text.toString()
            var txt12 = prowizja.text.toString()
            var txt13 = oprocentowanie.text.toString()
            var txt14 = kwota.text.toString()
            var txt15 = switch1.text.toString()
            var txt18 = android.text.toString()
            var txt19 = chce.text.toString()





    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)


    }


}