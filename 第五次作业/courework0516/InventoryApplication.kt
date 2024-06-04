package com.example.compose.courework0516

import android.app.Application
import com.example.compose.courework0516.data.AppContainer
import com.example.compose.courework0516.data.AppDataContainer

class InventoryApplication: Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}