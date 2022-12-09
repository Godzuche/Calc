package com.example.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calc.ui.theme.CalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcTheme {
                // A surface container using the 'background' color from the theme
                val viewModel: CalculatorViewModel = viewModel()
                val state = viewModel.state
                CalculatorScreen(
                    state = state,
                    onAction = { action ->
                        viewModel.onAction(action)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalcTheme {
        CalculatorScreen(
            onAction = {},
            state = CalculatorState()
        )
    }
}