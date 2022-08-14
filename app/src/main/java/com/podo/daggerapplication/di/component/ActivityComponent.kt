package com.podo.daggerapplication.di.component

import com.podo.daggerapplication.di.module.AbstractViewModelModule
import com.podo.daggerapplication.di.module.ViewModelModule
import com.podo.daggerapplication.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, AbstractViewModelModule::class])
interface ActivityComponent {
  fun inject(activity: MainActivity)
}