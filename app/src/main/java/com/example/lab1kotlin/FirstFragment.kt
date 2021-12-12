package com.example.lab1kotlin

import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment


class FirstFragment : Fragment() {

    private lateinit var radioGroup : RadioGroup
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView: TextView
    private lateinit var firstNumberText: TextView
    private lateinit var button: Button


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

        var operator = ""
        var result = 0.0

        button.setOnClickListener {
            try {
                val id = radioGroup.checkedRadioButtonId

                if (radioGroup.checkedRadioButtonId % 10 == 0)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) + getTextValue(editText2)).toString())
                    operator = "+"
                    result = (getTextValue(editText1) + getTextValue(editText2)).toDouble()
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 1)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) - getTextValue(editText2)).toString())
                    operator = "-"
                    result = (getTextValue(editText1) - getTextValue(editText2)).toDouble()
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 2)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) * getTextValue(editText2)).toString())
                    operator = "*"
                    result = (getTextValue(editText1) * getTextValue(editText2)).toDouble()
                }
                else if (radioGroup.checkedRadioButtonId % 10 == 3)
                {
                    (activity as MainActivity).getResult((getTextValue(editText1) / getTextValue(editText2)).toString())
                    operator = "/"
                    result = (getTextValue(editText1) / getTextValue(editText2)).toDouble()
                }
            }
            catch (e: Exception) {
                Toast.makeText(activity?.applicationContext, "You have to type float numbers in", Toast.LENGTH_SHORT).show()
            }
            val db: SQLiteDatabase? = activity?.openOrCreateDatabase("app.db", MODE_PRIVATE, null)
            db?.execSQL("CREATE TABLE IF NOT EXISTS calculations (firstValue REAL, secondValue REAL, operator STRING, result REAL)")
            db?.execSQL("INSERT OR IGNORE INTO calculations VALUES (${getTextValue(editText1)}, ${getTextValue(editText2)}, ${operator}, ${result});")
            val query: Cursor = db!!.rawQuery("SELECT * FROM calculations;", null)
            if (query.moveToFirst()) {
                val firstVal: Double = query.getDouble(0)
                val secondVal: Double = query.getDouble(1)
                val operation: String = query.getString(2)
                val result: Double = query.getDouble(3)


            }
            query.close()
            db.close()
        }


        return view
    }

    fun getTextValue(editComponent: EditText): Float {
        return editComponent.text.toString().toFloat()
    }
}