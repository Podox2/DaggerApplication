package com.podo.daggerapplication.concrete_approach.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R.layout
import com.podo.daggerapplication.concrete_approach.data.Car
import com.podo.daggerapplication.concrete_approach.data.Hero
import com.podo.daggerapplication.concrete_approach.data.Person
import com.podo.daggerapplication.di.component.Luna
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class ConcreteActivity : AppCompatActivity() {

  // в актівіті не можна інджектити в конструктор, тому інджектимо в поля
  // так не правильно інджектити в'ю модель
  @Inject
  lateinit var concreteViewModel: ConcreteViewModel

  // якщо депенденсі потрібне не завжди, то можна вказати, що воно було впровайджене в момент виклику (лінива ініціалізація)
  @Inject
  lateinit var car: Lazy<Car>

  // надає щоразу новий інстенс об'єкта. в чому прикол, якщо без синглтона теж саме?
  @Inject
  lateinit var person: Provider<Person>

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