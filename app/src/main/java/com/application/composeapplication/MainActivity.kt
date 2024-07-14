package com.application.composeapplication

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    private lateinit var uidText:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SettingScreen()
        }
    }
}


@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier.padding(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        )
    ) {
        TextContent(
            text = "Edit Name",
            paddingStart = 10,
            size = 25,
            weight = Bold,
            paddingTop = 20.0
        )
       val textFieldContent =  EditText()
        HorizontalDivider(
            thickness = 4.dp,
            modifier = Modifier.padding(top = 50.dp)
        )
        TextContent(
            text = "Additional",
            paddingTop = 40.0,
            size = 25,
            paddingStart = 10,
            weight = Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextContent(text = "UID: ", size = 20, weight = Bold, paddingStart = 5)
            UidText()
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_content_copy_24),
                    contentDescription = "",
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CheckBoxComposable()
                    Text(
                        text = "Add yourself as mate also?",
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
        Text(
            text = "Note: Checking the box will add yourself to the mates list to add and split dues for yourself also. ",
            modifier = Modifier.padding(30.dp)
        )
        ButtonComposable(
            text = "Save Changes",
            toastText = "Save Changes Button Clicked",
            textColor = Color.Green,
            borderStrokeWidth = 1.0,
            paddingTop = 60.0,
            data = textFieldContent
        )
        ButtonComposable(
            text = "Delete Account",
            toastText = "Delete Button Clicked",
            textColor = Color.Red,
            strokeColor = Color.Transparent,
            data = "data is being deleted"

        )
    }
}


@Composable
fun CheckBoxComposable() {
    val checkBoxState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkBoxState.value,
        onCheckedChange = { checkBoxState.value = it },
    )
}

@Composable
fun ButtonComposable(
    text: String,
    toastText: String = "",
    textColor: Color,
    borderStrokeWidth: Double = 0.0,
    strokeColor: Color = Color.Green,
    backgroundColor: Color = Color.Transparent,
    paddingTop: Double = 0.0,
    data:String
) {
    val context = LocalContext.current
    var changedData = ""
    Button(
        onClick =  { },
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = backgroundColor
        ),
        border = BorderStroke(borderStrokeWidth.dp, color = strokeColor),
        modifier = Modifier
            .padding(top = paddingTop.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Text(text = text)
    }
    UidText(text = changedData)
}


@Composable
fun UidText(text:String = ""){
    Text(text = text, fontSize = 16.sp)
}


@Composable
fun TextContent(
    text: String,
    paddingTop: Double = 0.0,
    paddingStart: Int = 0,
    size: Int = 0,
    weight: FontWeight = Normal,
) {
    Text(
        text = text,
        fontSize = size.sp,
        fontWeight = weight,
        modifier = Modifier
            .padding(start = paddingStart.dp)
            .padding(top = paddingTop.dp)
    )
}

@Composable
fun EditText(): String {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text(text = "Name") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
    )
    return state.value
}

@Composable
fun MateCard(text: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp, pressedElevation = 10.dp)
    )

    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                ImageComposable(R.drawable.baseline_person_24)
                TextComposable(text = text, fontWeight = Bold, fontSize = 18)
            }
            Row(
                Modifier.padding(top = 2.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ImageComposable(image = R.drawable.baseline_phone_24)
                TextComposable(text = "03126385200", fontWeight = Normal, fontSize = 14)
            }
            Row(Modifier.padding(top = 2.dp)) {
                Text(
                    text = "Mate ID: ",
                    fontWeight = Bold,
                    color = Color.Red
                )
                TextComposable(text = "wahaj@1", fontWeight = Normal, fontSize = 14)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Text(text = "Rent: ", fontWeight = Bold, color = Color.Red)
                    TextComposable(text = "0", fontWeight = Normal, fontSize = 14)
                }
                Row {
                    Text(text = "Others: ", fontWeight = Bold, color = Color.Red)
                    TextComposable(text = "0", fontWeight = Normal, fontSize = 14)
                }
                Row {
                    Text(text = "Wallet: ", fontWeight = Bold, color = Color.Red)
                    TextComposable(text = "0", fontWeight = Normal, fontSize = 14)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFunction() {
    SettingScreen()
}


@Composable
fun TextComposable(text: String, fontWeight: FontWeight, fontSize: Int) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize.sp
    )
}


@Composable
fun ImageComposable(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "person icon",
        colorFilter = ColorFilter.tint(Color.Red),
    )
}


//@Preview(name = "Text Field", showSystemUi = true)
//@Composable
//fun EditText() {
//    val state = remember { mutableStateOf("") }
//    TextField(value = state.value,
//        leadingIcon = { Image(painter = painterResource(id = R.drawable.baseline_message_24), contentDescription = "leading icon")},
//        label = { Text(text = "Enter Message") },
//        onValueChange = { state.value = it })
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun Button() {
//    androidx.compose.material3.Button(
//        onClick = {
//        }, colors = ButtonDefaults.buttonColors(
//            contentColor = Color.White,
//            containerColor = Color.Transparent
//        ),
//        border = BorderStroke(1.dp, Color.LightGray)
//    ) {
//        TextUI("Next")
//    }
//}
//
//
//@Preview(showSystemUi = true, name = "no internet image")
//@Composable
//fun ImageUI() {
//    Image(
//        painter = painterResource(id = R.drawable.baseline_navigate_next_24),
//        contentDescription = "Next Image",
//        alignment = Alignment.BottomEnd,
//        colorFilter = ColorFilter.tint(Color.LightGray),
//        contentScale = ContentScale.FillHeight,
//        modifier = Modifier.size(40.dp)
//    )
//}
//
//
//@Composable
//fun TextUI(name: String) {
//    Text(
//        name,
//        fontStyle = FontStyle.Normal,
//        fontSize = 30.sp,
//        textAlign = TextAlign.Center,
//        color = Color.LightGray
//    )
//}
