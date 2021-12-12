package com.example.lab1kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    private lateinit var textView2: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)
        textView2 = view.findViewById(R.id.textView2)
        return view
    }

    fun getResult(result: String){
        textView2.setText(result)
    }
}