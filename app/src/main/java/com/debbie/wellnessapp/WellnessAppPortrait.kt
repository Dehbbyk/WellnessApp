package com.debbie.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.debbie.wellnessapp.ui.theme.WellnessAppTheme

class WellnessAppPortraitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme{
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
                ){
                    WellnessAppPortrait()
                }

            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessAppPortrait() {
    val backgroundColor = colorResource(id = R.color.blue)
    WellnessAppTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar()}
        ){padding ->
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(ContextCompat.getColor(LocalContext.current, R.color.blue))
            ){
                HomeScreen(Modifier.padding(padding))
            }
        }
    }
}



@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WellnessAppPortraitPreview() {
    WellnessAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(ContextCompat.getColor(LocalContext.current, R.color.blue))
        ) {
            WellnessAppPortrait()
        }

    }
}