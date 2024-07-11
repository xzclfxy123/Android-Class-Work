package com.example.compose.middleexam

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.middleexam.data.News
import com.example.compose.middleexam.data.UserData
import com.example.compose.middleexam.ui.endPage.End
import com.example.compose.middleexam.ui.index.Index
import com.example.compose.middleexam.ui.newPage.News
import com.example.compose.middleexam.ui.novelPage.Novel
import com.example.compose.middleexam.ui.theme.MiddleExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiddleExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    color = Color(0xFFEEEEEE)
                ) {
                    MiddleExamTheme {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Index"){
        composable("Index"){ Index(navController)}
        composable("IndexPage"){ IndexPage(navController) }
        composable("News"){ News(navController,UserData.new)}
        composable("Novel"){ Novel(navController,UserData.novel)}
        composable("End"){ End(navController)}
    }
}

@Composable
fun IndexPage(
    navController: NavController,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
){

    Column(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = { navController.navigate("News")}) {
            Text(text = "新闻")
            Text(text = "")
        }

        Button(onClick = { navController.navigate("Novel")}) {
            Text(text = "小说")
        }

        Button(onClick = { navController.navigate("End")}) {
            Text(text = "结束")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MiddleExamTheme {
        Greeting()
    }
}