package com.podo.daggerapplication.concrete_approach.ui

import android.util.Log
import com.podo.daggerapplication.concrete_approach.data.Hero
import com.podo.daggerapplication.concrete_approach.repo.IRepo
import com.podo.daggerapplication.concrete_approach.repo.Store
import com.podo.daggerapplication.di.component.Luna
import javax.inject.Inject
import javax.inject.Named

class ConcreteViewModel @Inject constructor(
  // про ін'єкцію інтерфейсів написано в ConcreteRepoModule
  private val concreteRepo: IRepo,
  // тут відбувається ін'єкція конкретного класу, тому для Store не треба ніяких модулів. ін'єкції через конструктор достатньо.
  // ConcreteViewModel  провайдиться актівіті таким ж шляхом
  private val store: Store,
  // ін'єкція конкретного класу, але значення для конструктора не взяти з графа дагера. використовується @Provides в AppModule
  @Luna
  //@Named("Luna")
  private val hero: Hero
) {

  fun test() {
    Log.d("DAGGER_TAG", "ConcreteViewModel with ${concreteRepo.repoName()}, ${store.getName()}, and ${hero.name}")
  }
}