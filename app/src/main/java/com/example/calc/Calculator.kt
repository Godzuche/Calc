package com.example.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.ui.theme.LightGray
import com.example.calc.ui.theme.MediumGray
import com.example.calc.ui.theme.Orange

@Composable
fun CalculatorScreen(
    onAction: (CalculatorAction) -> Unit,
    buttonSpacing: Dp = 8.dp,
    state: CalculatorState
) {
    // Column
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = buttonSpacing,
            alignment = Alignment.Bottom
        ),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {

        val firstOperator = state.firstOperation?.symbol ?: ""
        val secondOperator = state.secondOperation?.symbol ?: ""
        val firstNumber = state.firstNumber
        val secondNumber = state.secondNumber

        Text(
            text = firstOperator + firstNumber + secondOperator + secondNumber,
            textAlign = TextAlign.Right,
            fontSize = 80.sp,
            color = Color.White,
            fontWeight = FontWeight.Light,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth()
        )
        // Row 1
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            CalculatorButton(
                symbol = "AC",
                onClick = {
                    onAction(CalculatorAction.Clear)
                },
                modifier = Modifier
                    .background(LightGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(2f)
                    .weight(2f)
            )
            CalculatorButton(
                symbol = "Del",
                icon = Icons.Filled.Delete,
                onClick = {
                    onAction(CalculatorAction.Delete)
                },
                modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "/",
                onClick = {
                    onAction(CalculatorAction.Operation(operation = CalculatorOperation.Divide))
                },
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f)
            )
        }
        // Row 2
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            CalculatorButton(
                symbol = "7",
                onClick = {
                    onAction(CalculatorAction.Number(7))
                },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "8",
                onClick = {
                    onAction(CalculatorAction.Number(8))
                },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "9",
                onClick = {
                    onAction(CalculatorAction.Number(9))
                },
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "x",
                onClick = {
                    onAction(CalculatorAction.Operation(operation = CalculatorOperation.Multiply))
                },
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f)
            )
        }
        // Row 3
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            CalculatorButton(
                symbol = "4",
                onClick = {
                    onAction(CalculatorAction.Number(4))
                },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "5",
                onClick = { onAction(CalculatorAction.Number(5)) },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "6",
                onClick = { onAction(CalculatorAction.Number(6)) },
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "-",
                onClick = {
                    onAction(CalculatorAction.Operation(operation = CalculatorOperation.Subtract))
                },
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f)
            )
        }
        // Row 4
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            CalculatorButton(
                symbol = "1",
                onClick = { onAction(CalculatorAction.Number(1)) },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "2",
                onClick = { onAction(CalculatorAction.Number(2)) },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "3",
                onClick = {},
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "+",
                onClick = {
                    onAction(CalculatorAction.Operation(operation = CalculatorOperation.Add))
                },
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f)
            )
        }
        // Row 5
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            CalculatorButton(
                symbol = "0",
                onClick = { onAction(CalculatorAction.Number(0)) },
                modifier = Modifier
                    .background(MediumGray)
                    // aspect ratio and weight of 2 to 1 of the other buttons
                    // means it should be 2 times the size of the others
                    .aspectRatio(2f)
                    .weight(2f)
            )
            CalculatorButton(
                symbol = ".",
                onClick = { onAction(CalculatorAction.Decimal) },
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f)
            )
            CalculatorButton(
                symbol = "=",
                onClick = { onAction(CalculatorAction.Calculate) },
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f)
            )
        }
    }
}