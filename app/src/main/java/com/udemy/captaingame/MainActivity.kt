package com.udemy.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udemy.captaingame.ui.theme.CaptainGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CaptainViewModel = viewModel()
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(
                        viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CaptainGame(viewModel: CaptainViewModel, modifier: Modifier = Modifier) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Treasures Found: ${state.treasuresFound}")
        Text(text = "Current Direction: ${state.direction}")
        Text(text = state.stormOrTreasure)

        SailButton(text = "East") { isItTreasure ->
           viewModel.updateState("East", isItTreasure)
        }
        SailButton(text = "South") { isItTreasure ->
            viewModel.updateState("South", isItTreasure)
        }
        SailButton( text = "West") { isItTreasure ->
            viewModel.updateState("West", isItTreasure)
        }
        SailButton(text = "North") { isItTreasure ->
            viewModel.updateState("North", isItTreasure)
        }

//    val treasuresFound = remember { mutableIntStateOf(0) }
//    val direction = remember { mutableStateOf("North") }
//    val stormOrTreasure = remember { mutableStateOf("") }

//        Button(onClick = {
//            direction.value = "East"
//            if (Random.nextBoolean()) {
//                treasuresFound.value++
//                stormOrTreasure.value = "Found a Treasure!"
//            } else {
//                stormOrTreasure.value = "Storm Ahead"
//            }
//        }) { Text("Sail East!") }
//        Button(onClick = {
//            direction.value = "North"
//            if (Random.nextBoolean()) {
//                treasuresFound.value++
//                stormOrTreasure.value = "Found a Treasure!"
//            } else {
//                stormOrTreasure.value = "Storm Ahead"
//            }
//        }) { Text("Sail North!") }
//        Button(onClick = {
//            direction.value = "West"
//            if (Random.nextBoolean()) {
//                treasuresFound.value++
//                stormOrTreasure.value = "Found a Treasure!"
//            } else {
//                stormOrTreasure.value = "Storm Ahead"
//            }
//        }) { Text("Sail West!") }
//        Button(onClick = {
//            direction.value = "South"
//            if (Random.nextBoolean()) {
//                treasuresFound.value++
//                stormOrTreasure.value = "Found a Treasure!"
//            } else {
//                stormOrTreasure.value = "Storm Ahead"
//            }
//        }) { Text("Sail South!") }
    }
}


@PreviewLightDark
@Composable
fun CaptainGamePreview(modifier: Modifier = Modifier) {
    CaptainGame(viewModel(), Modifier.background(MaterialTheme.colorScheme.background))
}
