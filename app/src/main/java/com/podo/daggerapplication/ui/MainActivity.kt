package com.podo.daggerapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.podo.daggerapplication.DaggerApplication
import com.podo.daggerapplication.R
import com.podo.daggerapplication.data.Car
import com.podo.daggerapplication.data.CoolClass
import com.podo.daggerapplication.data.CoolClassWithBuilder
import com.podo.daggerapplication.data.Hero
import com.podo.daggerapplication.data.Person
import com.podo.daggerapplication.di.ViewModelFactory
import com.podo.daggerapplication.di.extension.provideViewModel
import com.podo.daggerapplication.di.qualifier.Luna
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

  // в актівіті не можна інджектити в конструктор, тому інджектимо в поля

  // фабрику можна інджектити в поле
  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  // в'ю модельку можна отримати кількома шляхами, але не можна її просто інджектити
  // (бо в'ю модельку треба отримувати через спеціальну фабрику, а не через конструктор)
  private lateinit var viewModel: MainViewModel

  // якщо депенденсі потрібне не завжди, то можна вказати, щоб воно було впровайджене в момент виклику (лінива ініціалізація)
  @Inject
  lateinit var car: Lazy<Car>

  // надає щоразу новий інстенс об'єкта. використовується в ViewModelFactory
  @Inject
  lateinit var person: Provider<Person>

  @Inject
  lateinit var coolClass: CoolClass

  @Inject
  lateinit var coolClassWithBuilder: CoolClassWithBuilder

  // поле використовується в методі, який викликається одного разу при старті. можна замінити ін'єкцією в метод
  /*@Inject
  lateinit var hero: Hero*/

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    (application as DaggerApplication).appComponent.inject(this)

    findViewById<TextView>(R.id.tv_hello).setOnClickListener {
      startActivity(Intent(this, SecondActivity::class.java))
    }

    // фабрику можна не іджектити, а мати як поле в компоненті
    //concreteViewModel = (application as DaggerApplication).appComponent.viewModelFactory.create(ConcreteViewModel::class.java)

    // варіант, коли фабрика заінджекчена як поле актівіті
    //concreteViewModel = viewModelFactory.create(ConcreteViewModel::class.java)
    // також поле, але створення в'ю моделі через кастомний метод
    viewModel = provideViewModel(viewModelFactory)
    viewModel.test()

    // замінено ін'єкцією в метод
    //showHero(hero)

    // ініціалізація тільки в якийсь випадок
    val random = (0..2).shuffled().first()
    if (random == 1) {
      // треба робити get()
      car.get().doSomething()
    }

    coolClass.doSomethingCool()
    coolClassWithBuilder.doSomethingCool()
  }

  // ін'єкція в метод
  // використовується коли треба зробити якусь дію один раз, при наданні залежностей класу
  // тобто в метод інджектиться аргумент hero
  // @Luna чомусь не спрацьовує
  @Inject
  @Luna
  fun showHero(hero: Hero) {
    Log.d("DAGGER_TAG", "showHero: ${hero.name}")
  }
}