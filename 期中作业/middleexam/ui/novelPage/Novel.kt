package com.example.compose.middleexam.ui.novelPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.middleexam.data.Novel

@Composable
fun Novel(
    navController: NavController,
    novel: List<Novel>,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        for (i in novel.indices){
            Text(text = novel[i].name,modifier = Modifier
                .align(Alignment.Start)
                .padding(20.dp))
            Text(text = "details:",modifier = Modifier.padding(5.dp))
            Text(text = novel[i].details,modifier = Modifier.border(1.5.dp, Color(0xFF39c5bb)))
            Image(painter = painterResource(id = novel[i].cover), contentDescription = null, modifier = Modifier.fillMaxSize(0.9f))
        }
        Button(onClick = { navController.navigate("IndexPage")}) {
            Text(text = "返回主页")
        }
    }

}