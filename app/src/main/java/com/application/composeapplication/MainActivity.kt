

package com.application.composeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
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
   private  fun setData() {
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
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



data class MatesInfo(var mateName: String, var mateId: String, var matePhone: String)


@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun MateCard(mateName: String, mateId: String, matePhone: String, toastText: String = "") {
    val clicked = remember {
        mutableStateOf(false)
    }

    val scaffoldState = rememberScaffoldState()
    produceState(initialValue = false, key1 = 1, key2 = 2, key3 = 3) {
        val value = clicked.value
        if(value){
            scaffoldState.snackbarHostState.showSnackbar(toastText)
        }
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
            AnimatedVisibility(visible = clicked.value) {
                Buttons()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFunction() {
    MateCard(mateName = "Wahaj Sajid", mateId = "wahajsajid@1", matePhone = "03126385200")
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
