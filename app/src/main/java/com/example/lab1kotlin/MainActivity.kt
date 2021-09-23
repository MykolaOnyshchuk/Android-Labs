package com.example.lab1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var checked = "add"

        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            if(checkedId == R.id.radioButton1)
            {
                checked = "add"
            }
            if(checkedId == R.id.radioButton2)
            {
                checked = "substract"
            }
            if(checkedId == R.id.radioButton3)
            {
                checked = "multiply"
            }
            if(checkedId == R.id.radioButton4)
            {
                checked = "divide"
            }
        }

        button.setOnClickListener {
            try {
                if(checked == "add")
                {
                    textView2.text = (getTextValue(editText1) + getTextValue(editText2)).toString()
                }
                else if (checked == "substract")
                {
                    textView2.text = (getTextValue(editText1) - getTextValue(editText2)).toString()
                }
                else if (checked == "multiply")
                {
                    textView2.text = (getTextValue(editText1) * getTextValue(editText2)).toString()
                }
                else if (checked == "divide")
                {
                    textView2.text = (getTextValue(editText1) / getTextValue(editText1)).toString()
                }
            }
            catch (e: Exception) {
                Toast.makeText(this, "You have to type float numbers in", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getTextValue (editComponent: EditText): Float {
        return editComponent.text.toString().toFloat()
    }
}