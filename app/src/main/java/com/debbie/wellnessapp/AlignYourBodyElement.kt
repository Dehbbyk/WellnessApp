package com.debbie.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.debbie.wellnessapp.ui.theme.WellnessAppTheme

class AlignYourBodyElementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlignYourBodyRow()
                }
            }
        }
    }
}
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier

){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(alignYourBodyData){item->
            AlignYourBodyElement(item)
        }
    }
}

public val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_inversions,
    R.drawable.ab3_stretching to R.string.ab3_inversions,
    R.drawable.ab4_tabata to R.string.ab4_inversions,
    R.drawable.ab5_hiit to R.string.ab5_inversions,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_inversions,

).map { DrawableStringPair(it.first, it.second) }

//data class DrawableStringPair(
   // @DrawableRes val drawable: Int,
    //@StringRes val text: Int
//)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlignYourBodyElement(
    //@DrawableRes drawable: DrawableStringPair,
    //@StringRes text: Int,
    item: DrawableStringPair,
    modifier: Modifier =Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
            Image(
                painter = painterResource(item.drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(text = stringResource(item.text))

        }

    }



@Preview(showBackground = true)
@Composable
fun AlignYourBodyRowPreview() {
    WellnessAppTheme {
        AlignYourBodyRow()
    }
}