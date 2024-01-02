package com.debbie.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.leanback.widget.SearchBar
import com.debbie.wellnessapp.ui.theme.WellnessAppTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
                ) {
                    AlignYourBodyRow()
                    }
                }
            }
        }
    }

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier
        .verticalScroll(rememberScrollState())
    ){
        Spacer(Modifier.height(16.dp))
        WellnessSearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.alignyourbody) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favoritecollections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }

}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column (modifier){
        Text (
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }

}



@Preview(showBackground = true)
@Composable
fun ScreenContentPreview() {
    WellnessAppTheme{
        Surface (
            modifier = Modifier.fillMaxSize(),
                    color = Color(ContextCompat.getColor(LocalContext.current,R.color.blue))
        ){
            HomeScreen()
        }

        }
    }