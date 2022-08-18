package com.podo.daggerapplication.concrete_approach.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R.layout
import com.podo.daggerapplication.concrete_approach.data.Hero
import javax.inject.Inject
import javax.inject.Named

class ConcreteActivity : AppCompatActivity() {

  // в актівіті не можна інджектити в конструктор, тому інджектимо в поля
  // так не правильно інджектити в'ю модель
  @Inject
  lateinit var concreteViewModel: ConcreteViewModel

  // поле використовується в методі, який викликається одного разу при старті. можна замінити ін'єкцією в метод
  /*@Inject
  lateinit var hero: Hero*/

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_concrete)

    (application as DaggerApplication).appComponent.inject(this)

    // замінено ін'єкцією в метод
    //showHero(hero)

    concreteViewModel.test()
  }

  // ін'єкція в метод
  // використовується коли треба зробити якусь дію один раз, при наданні залежностей класу
  // @Named чомусь не спрацьовує
  @Inject
  @Named("Luna")
  fun showHero(hero: Hero) {
    Log.d("DAGGER_TAG", "showHero: ${hero.name}")
  }
}