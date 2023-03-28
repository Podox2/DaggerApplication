package com.podo.daggerapplication.di

import android.content.Context
import com.podo.daggerapplication.di.module.AppModule
import com.podo.daggerapplication.ui.MainActivity
import com.podo.daggerapplication.ui.SecondActivity
import com.podo.daggerapplication.ui.SomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// головний компонент, в якому вказаний головний модуль, або всі модулі аплікухи
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
  // можна надавати якісь типи прямо з компоненту
  // варіант коли фабрика - поле компоненту
  val viewModelFactory: ViewModelFactory
  // може бути як функція
  //fun viewModelFactory(): ViewModelFactory

  // без Дагер Андроїда або Hilt'а треба інджектити актівіті і фрагменти через такі функції
  fun inject(mainActivity: MainActivity)
  fun inject(secondActivity: SecondActivity)
  fun inject(someFragment: SomeFragment)

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun withContext(context: Context): Builder
    fun build(): AppComponent
  }
}