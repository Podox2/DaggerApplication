package com.podo.daggerapplication.di

import android.content.Context
import com.podo.daggerapplication.di.module.AppModule
import com.podo.daggerapplication.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// головний компонент, в якому вказаний головний модуль, або всі модулі аплікухи
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
  // варіант коли фабрика - поле компоненту
  val viewModelFactory: ViewModelFactory

  fun inject(mainActivity: MainActivity)

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun withContext(context: Context): Builder
    fun build(): AppComponent
  }
}