package com.example.simplecalculator.logic

object CalculatorLogic {
    private var operand1: Int = 0
    private var operand2: Int = 0
    private var operator: String = ""

    fun addNumber(number: Int) {
        if (operator.isEmpty()) {
            operand1 = operand1 * 10 + number
        } else {
            operand2 = operand2 * 10 + number
        }
    }

    fun setOperator(operator: String) {
        this.operator = operator
    }

    fun getCurrentOperand(): Int {
        return if (operator.isEmpty()) operand1 else operand2
    }

    fun calculateResult(): Int {
        val result =  when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> if (operand2 != 0) operand1 / operand2 else 0
            else -> 0
        }
        operand1 = result
        operand2 = 0
        return result
    }
}