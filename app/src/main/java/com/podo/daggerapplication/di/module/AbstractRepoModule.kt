package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.repo.IRepoByBinds
import com.podo.daggerapplication.repo.RepoByBinds
import dagger.Binds
import dagger.Module

@Module
abstract class AbstractRepoModule {

  @Binds
  abstract fun bindRepo(repoByBinds: RepoByBinds): IRepoByBinds
}