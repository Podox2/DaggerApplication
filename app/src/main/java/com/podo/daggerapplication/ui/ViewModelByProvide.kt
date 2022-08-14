package com.podo.daggerapplication.ui

import android.util.Log
import com.podo.daggerapplication.di.component.DaggerViewModelComponent
import com.podo.daggerapplication.repo.IRepoByBinds
import com.podo.daggerapplication.repo.RepoByConstructor
import com.podo.daggerapplication.repo.RepoByProvide
import javax.inject.Inject

class ViewModelByProvide(
  private val repoByConstructor: RepoByConstructor,
  private val repoByBinds: IRepoByBinds
) {

  @Inject
  lateinit var repoByProvide: RepoByProvide

  init {
    val viewModelComponent = DaggerViewModelComponent.builder().build()
    viewModelComponent.inject(this)
  }

  fun test() = Log.d(
    "DAGGER_TEST",
    "view model by provide, ${repoByConstructor.repoName}, ${repoByBinds.getName()},  and ${repoByProvide.repoName}"
  )
}