package com.example.calc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when {
            action is CalculatorAction.Number -> enterNumber(action.number)
            action is CalculatorAction.Operation -> addOperator(action.operation)
            action is CalculatorAction.Clear -> clearAllValue()
        }
    }

    private fun clearAllValue() {
        state = CalculatorState()
    }

    private fun addOperator(operation: CalculatorOperation) {
        if (state.secondNumber.isNotBlank()) {
            return
        }
        if (state.firstNumber.isNotBlank()) {
            state = state.copy(secondOperation = operation)
            return
        }
        if (operation == CalculatorOperation.Divide || operation == CalculatorOperation.Multiply) {
            return
        }
        state = state.copy(
            firstOperation = operation
        )

    }

    private fun enterNumber(number: Int) {
        if (state.secondOperation == null) {
            state = state.copy(
                firstNumber = state.firstNumber + number.toString()
            )
            return
        }
        if (state.secondOperation != null) {
            state = state.copy(
                secondNumber = state.secondNumber + number.toString()
            )
        }
    }
}