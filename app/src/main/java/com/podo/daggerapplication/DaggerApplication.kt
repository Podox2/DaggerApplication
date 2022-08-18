package com.podo.daggerapplication

import android.app.Application
import com.podo.daggerapplication.di.component.AppComponent
import com.podo.daggerapplication.di.component.DaggerAppComponent

class DaggerApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.create()
  }
}