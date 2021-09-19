package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {
    var ans = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (findViewById<EditText>(R.id.first_input) == null) {
            findViewById<Button>(R.id.sum_button).setOnClickListener {

                sum()
                answer(it)
            }

            findViewById<Button>(R.id.subtract_button).setOnClickListener {
                sub()
                answer(it)
            }

            findViewById<Button>(R.id.multiplication_button).setOnClickListener {
                mul()
                answer(it)
            }

            findViewById<Button>(R.id.divide_button).setOnClickListener {
                div()
            }
        }
    }

    fun answer(view: View) {
        val res = findViewById<TextView>(R.id.answer)

        if (ans % 100.0 == 0.0)
        {
            ans.toInt()
        }

        res.text = ans.toString()
        res.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun sum() {
        val first = parseDouble(findViewById<EditText>(R.id.first_input).getText().toString())
        val second = parseDouble(findViewById<EditText>(R.id.second_input).getText().toString())

        ans = first + second
    }

    fun sub() {
        val first = parseDouble(findViewById<EditText>(R.id.first_input).getText().toString())
        val second = parseDouble(findViewById<EditText>(R.id.second_input).getText().toString())

        ans = first - second
    }

    fun mul() {
        val first = parseDouble(findViewById<EditText>(R.id.first_input).getText().toString())
        val second = parseDouble(findViewById<EditText>(R.id.second_input).getText().toString())

        ans = first * second
    }

    fun div() {
        if (findViewById<EditText>(R.id.second_input).getText().toString().equals("0"))
        {
            val res = findViewById<TextView>(R.id.answer)

            res.text = "Division to 0"
            res.visibility = View.VISIBLE
        }
        else
        {
            val first = parseDouble(findViewById<EditText>(R.id.first_input).getText().toString())
            val second = parseDouble(findViewById<EditText>(R.id.second_input).getText().toString())

            val res = findViewById<TextView>(R.id.answer)


            res.text = (first / second).toString()
            res.visibility = View.VISIBLE
        }
    }
}