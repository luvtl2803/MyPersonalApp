package com.an.samplearch.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.an.samplearch.app.navigation.MtNavHost
import com.an.samplearch.ui.theme.SampleArchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleArchTheme {
                val navController = rememberNavController()
                MtNavHost(navController = navController)
            }
        }
    }
}