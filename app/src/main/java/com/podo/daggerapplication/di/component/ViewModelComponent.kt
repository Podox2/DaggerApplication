package com.podo.daggerapplication.di.component

import com.podo.daggerapplication.di.module.AbstractRepoModule
import com.podo.daggerapplication.ui.ViewModelByProvide
import dagger.Component
import javax.inject.Singleton

// компононент для демонстрації інджекста
@Singleton
@Component(modules = [AbstractRepoModule::class])
interface ViewModelComponent {
    fun inject(viewModelByProvide: ViewModelByProvide)
}