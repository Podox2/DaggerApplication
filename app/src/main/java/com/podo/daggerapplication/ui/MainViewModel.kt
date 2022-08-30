package com.podo.daggerapplication.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.podo.daggerapplication.data.Hero
import com.podo.daggerapplication.repo.Repo
import com.podo.daggerapplication.repo.Store
import com.podo.daggerapplication.di.qualifier.Luna
import javax.inject.Inject

class MainViewModel @Inject constructor(
  // про ін'єкцію інтерфейсів написано в ConcreteRepoModule
  private val concreteRepo: Repo,
  // тут відбувається ін'єкція конкретного класу, тому для Store не треба ніяких модулів. ін'єкції через конструктор достатньо.
  // ConcreteViewModel  провайдиться актівіті таким ж шляхом
  private val store: Store,
  // ін'єкція конкретного класу, але значення для конструктора не взяти з графа дагера. використовується @Provides в AppModule
  @Luna
  //@Named("Luna")
  private val hero: Hero
) : ViewModel() {

  fun test() {
    Log.d("DAGGER_TAG", "ConcreteViewModel with ${concreteRepo.repoName()}, ${store.getName()}, and ${hero.name}")
  }
}