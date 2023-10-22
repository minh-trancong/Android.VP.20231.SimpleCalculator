package com.example.simplecalculator.logic

class NumberButton(val number: Int) {
    fun onClick() {
        CalculatorLogic.addNumber(number)
    }
}