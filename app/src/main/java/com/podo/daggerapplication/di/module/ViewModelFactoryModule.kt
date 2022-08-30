package com.podo.daggerapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.podo.daggerapplication.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

  @Binds
  fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
  // чомусь в CTC проекті тип в аргументах такий же як і той, що повертається. можливо правильніше вказати реалізацію
  //fun provideViewModelFactory(viewModelFactory: ViewModelProvider.Factory): ViewModelProvider.Factory
}