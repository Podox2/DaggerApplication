package com.podo.daggerapplication

import android.app.Application
import com.podo.daggerapplication.di.AppComponent
import com.podo.daggerapplication.di.DaggerAppComponent

class DaggerApplication : Application() {

  lateinit var daggerAppComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    // якщо не треба провайдити зовнішні параметри, модулі, т.п., можна використати метод create()
    //appComponent = DaggerAppComponent.create()

    // для Андроїда треба часто провайдити контекст. в такому випадку треба юзати білдер
    daggerAppComponent = DaggerAppComponent.builder()
      .withContext(this)
      .build()
  }
}