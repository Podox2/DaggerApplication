package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.repo.RepoByProvide
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

  @Provides
  fun provideRepo(): RepoByProvide = RepoByProvide()
}