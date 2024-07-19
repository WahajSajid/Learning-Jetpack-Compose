package com.application.composeapplication

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//Composable function which render the mate card
@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun MateCard(mateName: String, mateId: String, matePhone: String, toastText: String = "") {
    val clicked = rememberSaveable {
        mutableStateOf(false)
    }
    val animation by animateDpAsState(
        targetValue = if (clicked.value) 5.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )

    val scaffoldState = rememberScaffoldState()
    produceState(initialValue = false, key1 = 1, key2 = 2, key3 = 3) {
        val value = clicked.value
        if (value) {
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
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = spring(Spring.DampingRatioHighBouncy,Spring.StiffnessMediumLow))
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                ImageComposable(R.drawable.baseline_person_24)
                TextComposable(text = mateName, fontWeight = Bold, fontSize = 18)
                if (clicked.value) ArrowDownAndUp(img = R.drawable.baseline_keyboard_arrow_up_24)
                else ArrowDownAndUp(img = R.drawable.baseline_arrow_drop_down_24)
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
          if(clicked.value){
              Buttons()
          }
        }
    }
}


@Composable
fun ArrowDownAndUp(img: Int) {
    Image(painter = painterResource(id = img), contentDescription = "arrow")
}


//Composable function which render the recycler view using LazyColumn
@Composable
fun RecyclerView(matesData: ArrayList<MatesInfo>) {
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


//Composable Function which render the buttons for the mate card
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

//Composable function which render the button for buttons layout in the mate card
@Composable
fun ButtonComposable(buttonText: String, color: Color = Color.DarkGray) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = buttonText)
    }
}


//Composable function which render the texts used in the mate card
@Composable
fun TextComposable(text: String, fontWeight: FontWeight, fontSize: Int) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
    )
}

//Composable function which render the vector used in the mate card
@Composable
fun ImageComposable(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "person icon",
        colorFilter = ColorFilter.tint(Color.Red),
    )
}


@Preview(widthDp = 320)
@Composable
private fun PreviewFunction() {
    MateCard(mateName = "Wahaj Sajid", mateId = "wahajsajid@1", matePhone = "03126385200")
}