package com.example.minicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var result = findViewById<TextView>(R.id.resultView)
        var num1 = findViewById<TextInputEditText>(R.id.firstNumber)
        var num2 = findViewById<TextInputEditText>(R.id.secondNumber)
        var add = findViewById<Button>(R.id.btnPlus)
        var sub = findViewById<Button>(R.id.btnMinus)
        var mul = findViewById<Button>(R.id.btnMultiply)
        var divide = findViewById<Button>(R.id.btnDivide)

        add.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                result.text = "Please enter two numbers"
            } else {
                var sum = num1.text.toString().toInt() + num2.text.toString().toInt()
                result.text = "Result: $sum"
            }
        }

        sub.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                result.text = "Please enter two numbers"
            } else {
                var diff = num1.text.toString().toInt() - num2.text.toString().toInt()
                result.text = "Result: $diff"
            }
        }

        mul.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                result.text = "Please enter two numbers"
            } else {
                var product = num1.text.toString().toInt() * num2.text.toString().toInt()
                result.text = "Result: $product"
            }
        }

        divide.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                result.text = "Please enter two numbers"
            } else {
                if (num2.text.toString().toInt() == 0) {
                    result.text = "Cannot divide by zero"
                } else {
                    var quotient = num1.text.toString().toInt() / num2.text.toString().toInt()
                    result.text = "Result: $quotient"
                }
            }
        }
    }
}