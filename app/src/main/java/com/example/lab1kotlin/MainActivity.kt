package com.example.lab1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getResult(result: String) {
        val fragmentManager = supportFragmentManager
        val secondFragment = fragmentManager.findFragmentById(R.id.fragment2) as SecondFragment
        secondFragment.getResult(result)
    }
}