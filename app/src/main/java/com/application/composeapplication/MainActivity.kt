@file:Suppress("UNUSED_EXPRESSION")

package com.application.composeapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    private lateinit var matesData: ArrayList<MatesInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setData()
            LazyColumn(content = {
                items(matesData) { item ->
                    MateCard(
                        mateName = item.mateName,
                        mateId = item.mateId,
                        matePhone = item.matePhone, toastText = item.mateName
                    )

                }
            })
        }
    }

    //Function to set the data for mates data
    fun setData() {
        matesData = ArrayList()
        matesData.add(MatesInfo("Wahaj Sajid", "wahajsajid@1", "03126385200"))
        matesData.add(MatesInfo("Basit Ali", "basit@2", "03126385201"))
        matesData.add(MatesInfo("Abdullah", "abdullah@3", "03126385202"))
        matesData.add(MatesInfo("Habibullah", "habibullah@4", "03126385203"))
        matesData.add(MatesInfo("Samiullah", "samiullah@5", "03126385204"))
        matesData.add(MatesInfo("Faiz", "faiz@6", "03126385205"))
        matesData.add(MatesInfo("Rustam", "rustam@7", "03126385206"))
        matesData.add(MatesInfo("Bilal", "bilal@8", "03126385207"))
        matesData.add(MatesInfo("Zulqar", "zulqar@9", "03126385208"))
        matesData.add(MatesInfo("Adnan", "adnan@10", "03126385209"))
        matesData.add(MatesInfo("Ahmad", "ahmad@11", "03126385210"))
        matesData.add(MatesInfo("Zain", "zain@12", "03126385211"))
        matesData.add(MatesInfo("Anas", "anas@13", "03126385212"))
        matesData.add(MatesInfo("Umair", "umair@14", "03126385213"))
        matesData.add(MatesInfo("Zeshan", "zeshan@15", "03126385214"))
        matesData.add(MatesInfo("Sufyan", "sufyan@16", "03126385215"))
    }

}


@Composable
fun Buttons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
    ) {
        ButtonComposable(buttonText = "Remove", Color.Red)
        ButtonComposable(buttonText = "Update")
        ButtonComposable(buttonText = "Edit")
    }
}

@Composable
fun ButtonComposable(buttonText: String, color: Color = Color.DarkGray) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = buttonText)
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
        val textFieldContent = EditText()
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
    data: String
) {
    val context = LocalContext.current
    var changedData = ""
    Button(
        onClick = { },
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
fun UidText(text: String = "") {
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


data class MatesInfo(var mateName: String, var mateId: String, var matePhone: String)


@Composable
fun MateCard(mateName: String, mateId: String, matePhone: String, toastText: String = "") {
    val context = LocalContext.current
    val clicked = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .clickable {
                Toast
                    .makeText(context, toastText, Toast.LENGTH_SHORT)
                    .show()
                clicked.value = !clicked.value
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp, pressedElevation = 10.dp)
    )

    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                ImageComposable(R.drawable.baseline_person_24)
                TextComposable(text = mateName, fontWeight = Bold, fontSize = 18)
            }
            Row(
                Modifier.padding(top = 2.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ImageComposable(image = R.drawable.baseline_phone_24)
                TextComposable(text = matePhone, fontWeight = Normal, fontSize = 14)
            }
            Row(Modifier.padding(top = 2.dp)) {
                Text(
                    text = "Mate ID: ",
                    fontWeight = Bold,
                    color = Color.Red
                )
                TextComposable(text = mateId, fontWeight = Normal, fontSize = 14)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
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
            if (clicked.value) {
                Buttons()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFunction() {
//    MateCard(mateName = "Wahaj Sajid", mateId = "wahajsajid@1", matePhone = "03126385200")
    Buttons()
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
