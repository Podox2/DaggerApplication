package com.podo.daggerapplication

import android.app.Application
import com.podo.daggerapplication.di.component.AppComponent
import com.podo.daggerapplication.di.component.DaggerAppComponent

class DaggerApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    // якщо не треба провайдити зовнішні параметри, модулі, т.п., можна використати метод create()
    //appComponent = DaggerAppComponent.create()

    // для андроїда треба провайдити контекст, тому треба юзати білдер
    appComponent = DaggerAppComponent.builder()
      .withContext(this)
      .build()
  }
}