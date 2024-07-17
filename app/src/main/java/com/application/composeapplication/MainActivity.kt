package com.application.composeapplication

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.ClipboardManager
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {
    private lateinit var matesData: ArrayList<MatesInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = ViewModelProvider(this)[SharedViewModel::class.java]
            SettingScreen(viewModel = viewModel)
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




