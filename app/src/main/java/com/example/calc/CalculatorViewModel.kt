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
            action is CalculatorAction.Delete -> delete()
            action is CalculatorAction.Decimal -> addDecimalPoint()
            action is CalculatorAction.Calculate -> calculateResult()
        }
    }

    private fun calculateResult() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {

            val result = when (state.secondOperation) {
                CalculatorOperation.Divide -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber / secondNumber
                    } else firstNumber / secondNumber
                }
                CalculatorOperation.Add -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber + secondNumber
                    } else firstNumber + secondNumber
                }
                CalculatorOperation.Subtract -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber - secondNumber
                    } else firstNumber - secondNumber
                }
                CalculatorOperation.Multiply -> {
                    if (state.firstOperation == CalculatorOperation.Subtract) {
                        -firstNumber * secondNumber
                    } else firstNumber * secondNumber
                }
                else -> null
            }

            state = state.copy(
                firstOperation = null,
                firstNumber = result.toString().take(15),
                secondOperation = null,
                secondNumber = ""
            )

        }
    }

    private fun addDecimalPoint() {
        if (state.secondNumber.isNotBlank() && !state.secondNumber.contains(".")) {
            state = state.copy(
                secondNumber = state.secondNumber + "."
            )
            return
        }
        if (
            state.secondOperation == null && state.firstNumber.isNotBlank()
            && !state.firstNumber.contains(".")
        ) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
        }
    }

    private fun delete() {
        when {
            state.secondNumber.isNotBlank() -> {
                state = state.copy(
                    secondNumber = state.secondNumber.dropLast(1)
                )
            }
            state.secondOperation != null -> {
                state = state.copy(
                    secondOperation = null
                )
            }
            state.firstNumber.isNotBlank() -> {
                state = state.copy(
                    firstNumber = state.firstNumber.dropLast(1)
                )
            }
            state.firstOperation != null -> {
                state = state.copy(
                    firstOperation = null
                )
            }
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