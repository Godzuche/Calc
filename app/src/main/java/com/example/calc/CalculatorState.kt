package com.example.calc

data class CalculatorState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val firstOperation: CalculatorOperation? = null,
    val secondOperation: CalculatorOperation? = null
)