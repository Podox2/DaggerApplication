package com.podo.daggerapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R.layout
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var viewModelByConstructor: ViewModelByConstructor
  @Inject
  lateinit var viewModelByProvide: ViewModelByProvide
  @Inject
  lateinit var viewModelByBinds: IViewModelByBinds

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    (application as DaggerApplication).appComponent.inject(this)

    viewModelByConstructor.test()
    viewModelByProvide.test()
    viewModelByBinds.test()
  }
}