package com.example.xzc2207020314no02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xzc2207020314no02.ui.theme.XZC2207020314No02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XZC2207020314No02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    XZC2207020314No02Theme {
                        Conversation(messages = users)
                    }
                }
            }
        }
    }
}
data class Message(val username: String, val introduction: String, val image: Painter)
val users: List<Message>
    @Composable
    get() = listOf(
        Message("lfxy01", "knao kawaii", painterResource(id = R.drawable.chise)),
        Message("lfxy02", "kano daisuki", painterResource(id = R.drawable.kano01)),
        Message("lfxy03", "kano sekaiichi", painterResource(id = R.drawable.kano02)),
        Message("lfxy04", "mika kawaii", painterResource(id = R.drawable.kano03)),
        Message("lfxy05", "mika daisuki", painterResource(id = R.drawable.yuuka)),
        Message("lfxy06", "mika sekaiichi", painterResource(id = R.drawable.esmcat))
    )

@Composable
fun MessageCard(mes:Message){
    Row(
        modifier = Modifier
            .padding(all = 15.dp)
    ) {
        Image(
            painter = mes.image,
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(0.7F)
        ) {
            Text(text = mes.username)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = mes.introduction)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "1 min ago",
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun Conversation(messages:List<Message>) {
    LazyColumn {
        items(messages) {item ->
            MessageCard(item)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun GreetingPreview() {
    XZC2207020314No02Theme {
        Conversation(messages = users)
    }
}