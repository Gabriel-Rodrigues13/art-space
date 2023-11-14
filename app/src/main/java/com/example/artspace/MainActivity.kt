package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    var currentImage by remember {
        mutableStateOf(1)
    }
    var currentTitle by remember {
        mutableStateOf(R.string.image_pencils_title)
    }
    var currentArtist by remember {
        mutableStateOf(R.string.image_pencils_artist)
    }

    when (currentImage) {
        1 -> ArtSpaceLayout(
            currentImage = R.drawable.pexels_ann_h_1762851,
            currentTitle = R.string.image_pencils_title,
            currentArtist = R.string.image_pencils_artist,
            onPreviousClick = {
                currentImage = 4
            },
            onNextClick = {
                currentImage = 2
            })

        2 -> ArtSpaceLayout(
            currentImage = R.drawable.pexels_julio_nery_1839919,
            currentTitle = R.string.image_paintings_title,
            currentArtist =R.string.image_paintings_artist ,
            onPreviousClick = { currentImage = 1 },
            onNextClick = { currentImage = 3 })

        3 -> ArtSpaceLayout(
            currentImage = R.drawable.pexels_anni_roenkae_3109820,
            currentTitle = R.string.image_blue_liquid_title,
            currentArtist = R.string.image_blue_liquid_artist,
            onPreviousClick = { currentImage = 2 },
            onNextClick = { currentImage = 4 })

        4 -> ArtSpaceLayout(
            currentImage = R.drawable.pexels_rov_camato_700413,
            currentTitle = R.string.image_museum_title,
            currentArtist = R.string.image_museum_artist,
            onPreviousClick = { currentImage = 3 },
            onNextClick = { currentImage = 1 })
    }


}

@Composable
fun ArtSpaceLayout(
    currentImage: Int,
    currentTitle: Int, currentArtist: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .padding(15.dp)
    ) {
        ArtImage(currentImage)
        Spacer(modifier = modifier.height(60.dp))
        ArtInfo(currentTitle, currentArtist)
        Spacer(modifier = modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Button(onClick = onPreviousClick) {
                Text(text = "Previous")

            }
            Spacer(modifier = modifier.weight(1f))
            Button(onClick = onNextClick) {
                Text(text = "Next")

            }
        }
    }
}

@Composable
fun ArtImage(
    imageResource: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "imagem",
        modifier
            .fillMaxWidth()
            .size(500.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtInfo(
    artTitle: Int,
    artArtist: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = artTitle),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = stringResource(id = artArtist),
            fontSize = 24.sp
        )

    }
}


