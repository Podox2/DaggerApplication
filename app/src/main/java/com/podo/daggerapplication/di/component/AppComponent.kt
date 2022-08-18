package com.podo.daggerapplication.di.component

import com.podo.daggerapplication.concrete_approach.ui.ConcreteActivity
import com.podo.daggerapplication.di.module.AppModule
import com.podo.daggerapplication.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

// головний компонент, в якому вказаний головний модуль, або всі модулі аплікухи
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

  fun inject(mainActivity: MainActivity)

  fun inject(concreteActivity: ConcreteActivity)
}