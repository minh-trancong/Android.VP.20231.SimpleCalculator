package com.example.simplecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding
import com.example.simplecalculator.logic.CalculatorLogic

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calculatorLogic = CalculatorLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up your buttons and other UI elements here
        binding.btn0.setOnClickListener { onNumberClick(0) }
        binding.btn1.setOnClickListener { onNumberClick(1) }
        binding.btn2.setOnClickListener { onNumberClick(2) }
        binding.btn3.setOnClickListener { onNumberClick(3) }
        binding.btn4.setOnClickListener { onNumberClick(4) }
        binding.btn5.setOnClickListener { onNumberClick(5) }
        binding.btn6.setOnClickListener { onNumberClick(6) }
        binding.btn7.setOnClickListener { onNumberClick(7) }
        binding.btn8.setOnClickListener { onNumberClick(8) }
        binding.btn9.setOnClickListener { onNumberClick(9) }

        binding.btnPlus.setOnClickListener { onOperatorClick("+") }
        binding.btnMinus.setOnClickListener { onOperatorClick("-") }
        binding.btnMultiple.setOnClickListener { onOperatorClick("*") }
        binding.btnDiv.setOnClickListener { onOperatorClick("/") }

        binding.btnEqual.setOnClickListener { onEqualsClick() }
    }

    private fun onNumberClick(number: Int) {
        calculatorLogic.addNumber(number)
        binding.primaryTv.text = calculatorLogic.getCurrentOperand().toString()
    }

    private fun onOperatorClick(operator: String) {
        calculatorLogic.setOperator(operator)
        binding.secondTv.text = operator
    }

    private fun onEqualsClick() {
        val result = calculatorLogic.calculateResult()
        // Display the result
        binding.primaryTv.text = result.toString()
    }
}
