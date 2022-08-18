package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.repo.IRepoByBinds
import com.podo.daggerapplication.repo.RepoByBinds
import com.podo.daggerapplication.repo.RepoByProvide
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AbstractRepoModule {

  companion object {
    @Provides
    fun provideRepo(): RepoByProvide = RepoByProvide()
  }

  @Binds
  abstract fun bindRepo(repoByBinds: RepoByBinds): IRepoByBinds
}