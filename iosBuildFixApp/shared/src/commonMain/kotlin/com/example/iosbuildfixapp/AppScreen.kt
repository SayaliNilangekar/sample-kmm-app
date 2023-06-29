package com.example.iosbuildfixapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.ui.Modifier
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun AppScreen() {

    var myData by remember { mutableStateOf(listOf(myResponse("", "Loading...", "Loading...", 0))) }

    Column(Modifier.fillMaxSize()) {

        Box(
            Modifier.weight(1f).padding(vertical = 10.dp, horizontal = 5.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                Title().title(),
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }

        Box(
            Modifier.weight(1f).align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {

            Text(
                myData.firstOrNull()?.setup ?: "",
                modifier = Modifier.paddingFromBaseline(bottom = 200.dp)
                    .padding(horizontal = 15.dp),
                color = Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
            Text(
                myData.firstOrNull()?.punchline ?: "",
                modifier = Modifier.paddingFromBaseline(top = 100.dp).padding(horizontal = 15.dp),
                color = Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }

        Box(
            Modifier.weight(1f).align(Alignment.CenterHorizontally).padding(vertical = 10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            val scope = rememberCoroutineScope()

            Button(
                onClick = {
                    // Call api here to get new joke
                    scope.launch {
                        myData = try {
                            println("In try block!")
                            val response = getResponse()
                            println("myData: " + myData)
                            response
                        } catch (e: Exception) {
                            e.printStackTrace()
                            listOf(myResponse("", "", "", 0))
                        }
                    }
                }
            ) {
                Text(
                    "Get new joke",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        LaunchedEffect(true) {
            try {
                myData = getResponse()
            } catch (e: Exception) {
                e.printStackTrace()
                myData = listOf(myResponse("", "", "", 0))
            }
        }
    }
}