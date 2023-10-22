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

    // Clear Entry - Xóa toán hạng hiện tại về 0
    fun clearEntry() {
        if (operator.isEmpty()) {
            operand1 = 0
        } else {
            operand2 = 0
        }
    }

    // Clear - Xóa phép tính
    fun clear() {
        operand1 = 0
        operand2 = 0
        operator = ""
    }

    // Backspace - Xóa chữ số hàng đơn vị của toán hạng hiện tại (nếu còn 1 chữ số thì xóa về 0)
    fun backspace() {
        if (operator.isEmpty()) {
            operand1 /= 10
        } else {
            operand2 /= 10
        }
    }
}