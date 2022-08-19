package com.podo.daggerapplication.concrete_approach.data

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor() {

  fun doSomething() {
    Log.d("DAGGER_TAG", "car did something")
  }
}