package com.podo.daggerapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.podo.daggerapplication.R.layout
import com.podo.daggerapplication.di.component.DaggerActivityComponent
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

    val activityComponent = DaggerActivityComponent.builder()
      .build()

    activityComponent.inject(this)
    viewModelByConstructor.test()
    viewModelByProvide.test()
    viewModelByBinds.test()
  }
}