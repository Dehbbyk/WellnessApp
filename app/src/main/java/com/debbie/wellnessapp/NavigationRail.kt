package com.debbie.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.debbie.wellnessapp.ui.theme.WellnessAppTheme

class NavigationRailAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
                ){
                    Row{
                        NavigationRailApp()
                        HomeScreen()
                    }
                }
            }
        }
    }
}
@Composable
fun NavigationRailApp(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ){
        Column(
            modifier= modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            
        ){
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottomnavigation))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottomnavigationp))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}
@Composable
fun WellnessLandscape() {

    WellnessAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
        ){
            Row{
                NavigationRailApp()
                HomeScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationRailPreview() {
    WellnessAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
        ){
            Row{
                NavigationRailApp()
                HomeScreen()
            }
        }
    }
}
