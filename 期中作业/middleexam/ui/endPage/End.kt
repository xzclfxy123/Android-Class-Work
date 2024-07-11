package com.example.compose.middleexam.ui.endPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun End(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    var content by remember{ mutableStateOf ("Exam Over") }
    Column (
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ){
        Button(onClick = { navController.navigate("IndexPage") }) {
            Text(text = "返回主页")
        }
        Button(onClick = { content = "考试结束" }) {
            Text(text = content)
        }
    }
}