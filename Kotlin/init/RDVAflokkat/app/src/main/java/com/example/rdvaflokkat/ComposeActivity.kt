package com.example.rdvaflokkat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistCard()
        }
    }
}

@Composable
fun ArtistCard() {
    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val image: Painter = painterResource(id = R.drawable.aflokkat)
            Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
            Text("Alfred Sysley")
        }
        Spacer(Modifier.size(padding))
        Card(elevation = 4.dp) {
        }
    }
}

@Preview(showBackground = true)

@Composable
fun DefaultPreview() {
    ArtistCard()
}