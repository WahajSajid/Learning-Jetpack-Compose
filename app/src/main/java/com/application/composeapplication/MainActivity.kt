package com.application.composeapplication

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EditText()
        }
    }
}


@Preview(name = "Text Field", showSystemUi = true)
@Composable
fun EditText() {
    val state = remember{mutableStateOf("")}
    TextField(value = state.value,
        trailingIcon = { ImageUI()},
        label = { Text(text = "Enter Message")},
        onValueChange = {state.value = it})
}
@Preview(showSystemUi = true, name = "Button")
@Composable
fun Button() {
    androidx.compose.material3.Button(
        onClick = { }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        TextUI("Next")
        ImageUI()
    }
}


@Preview(showSystemUi = true, name = "no internet image")
@Composable
fun ImageUI() {
    Image(
        painter = painterResource(id = R.drawable.baseline_navigate_next_24),
        contentDescription = "Next Image",
        alignment = Alignment.BottomEnd,
        colorFilter = ColorFilter.tint(Color.LightGray),
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.size(40.dp)
    )
}


@Composable
fun TextUI(name: String) {
    Text(
        name,
        fontStyle = FontStyle.Normal,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        color = Color.LightGray
    )
}
