package com.example.calc

// A model class for the calculator UI events

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Delete : CalculatorAction()
    object Clear : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal : CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}

sealed class CalculatorOperation(val symbol: String) {
    object Multiply : CalculatorOperation(symbol = "*")
    object Add : CalculatorOperation(symbol = "+")
    object Subtract : CalculatorOperation(symbol = "-")
    object Divide : CalculatorOperation(symbol = "/")
}
