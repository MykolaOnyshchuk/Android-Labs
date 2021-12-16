package com.example.lab1kotlin

import android.content.Context.MODE_APPEND
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import java.io.FileOutputStream
import java.io.IOException


class FirstFragment : Fragment() {

    private lateinit var radioGroup : RadioGroup
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView: TextView
    private lateinit var firstNumberText: TextView
    private lateinit var button: Button
    private lateinit var buttonOpen: Button

    private val FILE_NAME = "text.txt"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        radioGroup = view.findViewById(R.id.radioGroup)
        editText1 = view.findViewById(R.id.editText1)
        editText2 = view.findViewById(R.id.editText2)
        textView = view.findViewById(R.id.textView)
        firstNumberText = view.findViewById(R.id.firstNumberText)
        button = view.findViewById(R.id.button)
        buttonOpen = view.findViewById(R.id.buttonOpen)

        val intentActivity2 = Intent(activity?.applicationContext, SecondActivity::class.java)

        var operator = ""
        var result = 0.0

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

                if (checked == "add")
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) + getTextValue(editText2)).toString())
                    operator = "+"
                    result = (getTextValue(editText1) + getTextValue(editText2)).toDouble()
                }
                else if (checked == "substract")
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) - getTextValue(editText2)).toString())
                    operator = "-"
                    result = (getTextValue(editText1) - getTextValue(editText2)).toDouble()
                }
                else if (checked == "multiply")
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) * getTextValue(editText2)).toString())
                    operator = "*"
                    result = (getTextValue(editText1) * getTextValue(editText2)).toDouble()
                }
                else if (checked == "divide")
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) / getTextValue(editText2)).toString())
                    operator = "/"
                    result = (getTextValue(editText1) / getTextValue(editText2)).toDouble()
                }
            }
            catch (e: Exception) {
                Toast.makeText(activity?.applicationContext, "You have to type float numbers in", Toast.LENGTH_SHORT).show()
            }


            var fos: FileOutputStream? = null
            try {

                fos = context?.openFileOutput(FILE_NAME, MODE_APPEND)
                fos?.write((editText1.text.toString() + operator + editText2.text.toString() + "=" + result + "\n").toByteArray())
                Toast.makeText(activity?.applicationContext, "Saved", Toast.LENGTH_LONG).show()
            } catch (ex: IOException) {
                Toast.makeText(activity?.applicationContext, "Error writing to file", Toast.LENGTH_LONG).show()
            } finally {
                try {
                    fos?.close()
                } catch (ex: IOException) {
                    Toast.makeText(activity?.applicationContext, "Error opening stream", Toast.LENGTH_LONG).show()
                }
            }

        }

        buttonOpen.setOnClickListener{
            startActivity(intentActivity2)
        }


//            val db: SQLiteDatabase? = activity?.openOrCreateDatabase("app.db", MODE_PRIVATE, null)
//            db?.execSQL("CREATE TABLE IF NOT EXISTS calculations (firstValue REAL, secondValue REAL, operator STRING, result REAL)")
//            db?.execSQL("INSERT OR IGNORE INTO calculations VALUES (${getTextValue(editText1)}, ${getTextValue(editText2)}, ${operator}, ${result});")
//            val query: Cursor = db!!.rawQuery("SELECT * FROM calculations;", null)
//            if (query.moveToFirst()) {
//                val firstVal: Double = query.getDouble(0)
//                val secondVal: Double = query.getDouble(1)
//                val operation: String = query.getString(2)
//                val result: Double = query.getDouble(3)
//
//
//            }
//            query.close()
//            db.close()


        return view
    }

    fun getTextValue(editComponent: EditText): Float {
        return editComponent.text.toString().toFloat()
    }
}