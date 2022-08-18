package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.concrete_approach.data.Hero
import com.podo.daggerapplication.concrete_approach.di.ConcreteBindRepoModule
import com.podo.daggerapplication.concrete_approach.di.ConcreteProvideRepoModule
import com.podo.daggerapplication.di.component.Luna
import dagger.Module
import dagger.Provides
import javax.inject.Named

// можна мати один головний модуль, в якому прописані всі модулі аплікухи
// можна ж прописати всі ці модулі в AppComponent (так зроблено в Kiosk)
@Module(
  includes = [
    AbstractRepoModule::class,
    AbstractViewModelModule::class,
    RepoModule::class,
    ViewModelModule::class,
    ConcreteBindRepoModule::class,
    ConcreteProvideRepoModule::class
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
}