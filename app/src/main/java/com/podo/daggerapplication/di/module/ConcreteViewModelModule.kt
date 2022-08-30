package com.podo.daggerapplication.di.module

import androidx.lifecycle.ViewModel
import com.podo.daggerapplication.di.qualifier.ViewModelKey
import com.podo.daggerapplication.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ConcreteViewModelModule {

  // без масиву
  //@IntoMap
  //@ViewModelKey(ConcreteViewModel::class)
  // масив анотацій
  //@[IntoMap ViewModelKey(MainViewModel::class)]


  // всі в'ю модельки додаються в мапу. в одній мапі будуть об'єкти тільки одного типу (в даному випадку всі в'ю модельки наслідуються від ViewModel)
  // без анотації ViewModelKey, потрібно юзати ClassKey, але тоді у фабриці не можна використовувати конкретний тип ViewModel
  @Binds
  @[IntoMap ViewModelKey(MainViewModel::class)]
  fun provideConcreteViewModel(mainViewModel: MainViewModel): ViewModel
}