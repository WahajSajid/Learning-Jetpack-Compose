package com.application.composeapplication

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.buildAnnotatedString

//Composable function which render the Setting Screen UI
@Composable
fun SettingScreen(viewModel: SharedViewModel) {
    val textState = remember {
        mutableStateOf("")
    }
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
        EditText(viewModel)
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
            UidText(text = textState.value)
            Spacer(modifier = Modifier.weight(2f))
            CopyButton(text = textState.value)

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
            { textState.value = viewModel.editTextState.value },
            text = "Save Changes",
            textColor = Color.Green,
            borderStrokeWidth = 1.0,
            paddingTop = 60.0
        )
        ButtonComposable(
            { textState.value = "" },
            text = "Delete Account",
            textColor = Color.Red,
            strokeColor = Color.Transparent

        )
    }
}


@SuppressLint("ServiceCast")
@Composable
fun CopyButton(text: String) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val annotatedText = buildAnnotatedString { append(text) }
    Button(
        onClick = {
            clipboardManager.setText(annotatedString = annotatedText)
            Toast.makeText(context,"$annotatedText copied to clipboard",Toast.LENGTH_SHORT).show()
        },
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


//Composable function render the Text Field for Setting screen
@Composable
fun EditText(viewModel: SharedViewModel) {
    TextField(
        value = viewModel.editTextState.value,
        onValueChange = { viewModel.editTextState.value = it },
        label = { Text(text = "Name") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
    )
}


//Composable function which render all the texts used Setting Screen
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


//Composable function which render the UID text used in Setting Screen
@Composable
fun UidText(text: String = "") {
    Text(text = text, fontSize = 16.sp)
}


//Composable which render the buttons used in Setting screen
@Composable
fun ButtonComposable(
    updateText: () -> Unit = {},
    text: String,
    textColor: Color,
    borderStrokeWidth: Double = 0.0,
    strokeColor: Color = Color.Green,
    backgroundColor: Color = Color.Transparent,
    paddingTop: Double = 0.0,
) {
    Button(
        onClick = { updateText() },
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
}


//Composable function which render the check box used in Setting screen
@Composable
fun CheckBoxComposable() {
    val checkBoxState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkBoxState.value,
        onCheckedChange = { checkBoxState.value = it },
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewFunction() {
    SettingScreen(viewModel = SharedViewModel())
}