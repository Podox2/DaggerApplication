package com.podo.daggerapplication.di.component

import com.podo.daggerapplication.di.module.RepoModule
import com.podo.daggerapplication.ui.ViewModelByProvide
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepoModule::class])
interface ViewModelComponent {
    fun inject(viewModelByProvide: ViewModelByProvide)
}