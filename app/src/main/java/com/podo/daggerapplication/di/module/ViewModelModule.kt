package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.repo.RepoByBinds
import com.podo.daggerapplication.repo.RepoByConstructor
import com.podo.daggerapplication.repo.RepoByProvide
import com.podo.daggerapplication.ui.ViewModelByProvide
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

  @Provides
  fun provideViewModel(
    repoByConstructor: RepoByConstructor,
    repoByProvide: RepoByProvide,
    repoByBinds: RepoByBinds
  ): ViewModelByProvide =
    ViewModelByProvide(repoByConstructor, repoByProvide, repoByBinds)
}