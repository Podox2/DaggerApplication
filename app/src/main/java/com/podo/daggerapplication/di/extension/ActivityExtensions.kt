package com.podo.daggerapplication.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Extension function to provide view model scoped to this [Activity] by default.
 *
 * @param factory provider factory that is responsible to instantiate ViewModel.
 * @param owner a scope that owns created ViewModel.
 */
// метод з CTC проекту
inline fun <reified T : ViewModel> Activity.provideViewModel(
  factory: ViewModelProvider.Factory,
  owner: ViewModelStoreOwner = this as ViewModelStoreOwner
): T {
  return ViewModelProvider(owner, factory)[T::class.java]
}