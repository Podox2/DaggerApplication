package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.ui.IViewModelByBinds
import com.podo.daggerapplication.ui.ViewModelByBinds
import dagger.Binds
import dagger.Module

@Module
abstract class AbstractViewModelModule {

  @Binds
  abstract fun bindViewModel(viewModelByBinds: ViewModelByBinds): IViewModelByBinds
}