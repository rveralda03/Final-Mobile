package com.d121211066.alcoholic

import android.app.Application
import  com.d121211066.alcoholic.data.AppContainer
import  com.d121211066.alcoholic.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}