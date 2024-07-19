package com.application.composeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Surface
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    private lateinit var matesData: ArrayList<MatesInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setData()
            RecyclerView(matesData = matesData)
        }
    }

    //Function to set the data for mates data
    private fun setData() {
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


data class MatesInfo(var mateName: String, var mateId: String, var matePhone: String)


@Composable
fun TextUi(
    names: ArrayList<String> = ArrayList(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for(name in names){
                Text(text = name)
            }
        }
    }

}


@Preview(widthDp = 320)
@Composable
private fun PreviewFunction() {
    TextUi(
        names = arrayListOf("Wahaj Sajid"), modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    )
}





