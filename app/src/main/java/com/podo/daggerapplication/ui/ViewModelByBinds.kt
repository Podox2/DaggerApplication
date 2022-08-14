package com.podo.daggerapplication.ui

import android.util.Log
import com.podo.daggerapplication.repo.IRepoByBinds
import com.podo.daggerapplication.repo.RepoByConstructor
import com.podo.daggerapplication.repo.RepoByProvide
import javax.inject.Inject

class ViewModelByBinds @Inject constructor(
    //private val repoByProvide: RepoByProvide,
    private val repoByConstructor: RepoByConstructor,
    //private val repoByBinds: IRepoByBinds
): IViewModelByBinds {

    override fun test() {
        Log.d("DAGGER_TEST", "view model by binds")
    }
}