package com.example.bankacc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankacc.ui.theme.BankaccTheme

// This class is now correctly defined as an Android Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Keep this line if it was in your original template
        super.onCreate(savedInstanceState)
        setContent {
            BankaccTheme {
                // Here you would display your Android UI
                // We'll just display a simple message for now.
                BankAppScreen()
            }
        }
    }
}

@Composable
fun BankAppScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Assignment Code is in AccountLogic.kt!",
        modifier = modifier.fillMaxSize()
    )
    // You can call your main() function here if you want to run the test and
    // see the output in the Android Logcat/Run console, but it's not standard practice.
    // main()
}

@Preview(showBackground = true)
@Composable
fun BankAppPreview() {
    BankaccTheme {
        BankAppScreen()
    }
}