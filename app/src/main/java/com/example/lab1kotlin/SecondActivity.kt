package com.example.lab1kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.io.FileInputStream
import java.io.IOException

class SecondActivity : AppCompatActivity() {

    private val FILE_NAME = "text.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        openText()
    }

    @SuppressLint("SetTextI18n")
    fun openText() {
        var fin: FileInputStream? = null
        val textView = findViewById<TextView>(R.id.textView3)
        try {
            fin = openFileInput(FILE_NAME)
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            val text = String(bytes)
            textView.text = text
        } catch (ex: IOException) {
            textView.text = "File is empty"
            Toast.makeText(this, "File is empty", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fin?.close()
            } catch (ex: IOException) {
                Toast.makeText(this, "Error closing stream", Toast.LENGTH_SHORT).show()
            }
        }
    }
}