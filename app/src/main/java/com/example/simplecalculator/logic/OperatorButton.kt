package com.example.simplecalculator.logic

class OperatorButton(val operator: String) {
    fun onClick() {
        CalculatorLogic.setOperator(operator)
    }
}