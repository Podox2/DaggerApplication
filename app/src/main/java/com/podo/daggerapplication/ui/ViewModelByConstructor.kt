package com.podo.daggerapplication.ui

import android.util.Log
import com.podo.daggerapplication.repo.RepoByConstructor
import com.podo.daggerapplication.repo.RepoByProvide
import javax.inject.Inject

class ViewModelByConstructor @Inject constructor(
    private val repoByConstructor: RepoByConstructor/*,
  private val repoByProvide: RepoByProvide*/
) {

    fun test() =
        Log.d("DAGGER_TEST", "view model by constructor, and ${repoByConstructor.repoName}")
}