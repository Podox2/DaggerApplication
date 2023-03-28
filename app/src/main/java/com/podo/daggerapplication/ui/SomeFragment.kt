package com.podo.daggerapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R
import com.podo.daggerapplication.data.CoolClass
import javax.inject.Inject

class SomeFragment : Fragment(R.layout.fragment_some) {

  @Inject
  lateinit var coolClass: CoolClass

  override fun onAttach(context: Context) {
    (context.applicationContext as DaggerApplication).appComponent.inject(this)
    super.onAttach(context)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<TextView>(R.id.tv_fragment).text = "Fragment with ${coolClass.returnString()} by Dagger2"
  }
}