package com.podo.daggerapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

// Ключ - тип ViewModel, значення - Provider, який є фабрикою, яка надає ViewModel
// Provider надає щоразу новий об'єкт
class ViewModelFactory @Inject constructor(
  private val viewModelFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return viewModelFactories.getValue(modelClass as Class<ViewModel>).get() as T
  }

  val viewModelsClasses get() = viewModelFactories.keys
}