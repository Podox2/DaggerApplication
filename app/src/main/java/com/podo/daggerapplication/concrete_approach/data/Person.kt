package com.podo.daggerapplication.concrete_approach.data

import android.util.Log
import javax.inject.Inject

class Person @Inject constructor() {

  var counter = 0

  init {
    counter++
  }

  fun someAction() {
    Log.d("DAGGER_TAG", "some action from person - $counter")
  }
}