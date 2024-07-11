package com.example.compose.middleexam.ui.index

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Index(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ){
        Button(onClick = { navController.navigate("IndexPage") }) {
            Text(text = "Enter")
        }
    }
}