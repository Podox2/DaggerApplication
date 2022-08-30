package com.podo.daggerapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R.layout
import com.podo.daggerapplication.data.Car
import com.podo.daggerapplication.data.Hero
import com.podo.daggerapplication.data.Person
import com.podo.daggerapplication.di.ViewModelFactory
import com.podo.daggerapplication.di.provideViewModel
import com.podo.daggerapplication.di.qualifier.Luna
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

  // в актівіті не можна інджектити в конструктор, тому інджектимо в поля
  // так не правильно інджектити в'ю модель
  @Inject
  lateinit var viewModelFactory: ViewModelFactory
  lateinit var mainViewModel: MainViewModel

  // якщо депенденсі потрібне не завжди, то можна вказати, що воно було впровайджене в момент виклику (лінива ініціалізація)
  @Inject
  lateinit var car: Lazy<Car>

  // надає щоразу новий інстенс об'єкта. використовується в ViewModelFactory
  @Inject
  lateinit var person: Provider<Person>

  // поле використовується в методі, який викликається одного разу при старті. можна замінити ін'єкцією в метод
  /*@Inject
  lateinit var hero: Hero*/

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    (application as DaggerApplication).appComponent.inject(this)
    //concreteViewModel = (application as DaggerApplication).appComponent.viewModelFactory.create(ConcreteViewModel::class.java)
    //concreteViewModel = viewModelFactory.create(ConcreteViewModel::class.java)
    mainViewModel = provideViewModel(viewModelFactory)

    // замінено ін'єкцією в метод
    //showHero(hero)

    mainViewModel.test()

    // ініціалізація тільки в якийсь випадок
    val random = (0..2).shuffled().first()
    if (random == 1) {
      // треба робити get()
      car.get().doSomething()
    }
  }

  // ін'єкція в метод
  // використовується коли треба зробити якусь дію один раз, при наданні залежностей класу
  // @Luna чомусь не спрацьовує
  @Inject
  @Luna
  fun showHero(hero: Hero) {
    Log.d("DAGGER_TAG", "showHero: ${hero.name}")
  }
}