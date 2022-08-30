package com.podo.daggerapplication.di.module

import android.content.Context
import android.content.res.Resources
import com.podo.daggerapplication.data.Hero
import com.podo.daggerapplication.di.qualifier.Luna
import dagger.Module
import dagger.Provides

// можна мати один головний модуль, в якому прописані всі модулі аплікухи
// можна ж прописати всі ці модулі в AppComponent (так зроблено в Kiosk)
@Module(
  includes = [
    ConcreteBindRepoModule::class,
    ConcreteProvideRepoModule::class,
    ConcreteViewModelModule::class,
    ViewModelFactoryModule::class
  ]
)
class AppModule {

  @Provides
  fun provideHero() = Hero("Sven", 1000, 100)

  // власна анотація-кваліфікатор @Luna
  @Provides
  @Luna
  //@Named("Luna")
  fun provideHeroLuna() = Hero("Luna", 800, 200)

  // провайд, щоб десь використати контекст, як депенденсі
  @Provides
  fun provideResources(context: Context): Resources = context.resources
}