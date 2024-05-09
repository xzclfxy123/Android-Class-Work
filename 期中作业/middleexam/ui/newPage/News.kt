package com.example.compose.middleexam.ui.newPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavHostController
import com.example.compose.middleexam.data.News

@Composable
fun News(
    navController: NavHostController,
    news:List<News>,
    modifier: Modifier = Modifier
){
    Column(
        modifier=modifier
            .verticalScroll(rememberScrollState())
    ) {
        for (i in news.indices){
            Text(text = news[i].name,modifier = Modifier
                .align(Alignment.Start)
                .padding(20.dp))
            Text(text = "details:",modifier = Modifier.padding(5.dp))
            Text(text = news[i].details,modifier = Modifier.border(1.5.dp, Color(0xFF39c5bb)))
            Image(painter = painterResource(id = news[i].cover), contentDescription = null,modifier = Modifier.padding(5.dp))
        }
        Button(onClick = { navController.navigate("IndexPage")}) {
            Text(text = "返回主页")
        }
    }

}