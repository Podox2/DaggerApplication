package com.podo.daggerapplication

import android.content.Context
import com.podo.daggerapplication.di.AppComponent

// екстеншн, щоб отримувати daggerAppComponent не через каст application'а. див. MainActivity.onCreate()
val Context.appComponent: AppComponent
  get() = when (this) {
    is DaggerApplication -> daggerAppComponent
    else -> this.applicationContext.appComponent
  }