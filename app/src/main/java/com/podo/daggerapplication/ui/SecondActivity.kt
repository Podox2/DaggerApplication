package com.podo.daggerapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R
import com.podo.daggerapplication.data.CoolClass
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

  @Inject
  lateinit var coolClass: CoolClass

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    (application as DaggerApplication).daggerAppComponent.inject(this)

    coolClass.doSomethingCool()

    findViewById<TextView>(R.id.tv).text = "Second Activity with ${coolClass.returnString()} by Dagger2"

    supportFragmentManager
      .beginTransaction()
      .add(R.id.fragment_container, SomeFragment())
      .commit()
  }
}