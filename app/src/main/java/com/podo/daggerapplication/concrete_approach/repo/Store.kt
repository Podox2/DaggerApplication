package com.podo.daggerapplication.concrete_approach.repo

import javax.inject.Inject

class Store @Inject constructor() {

  fun getName() = "Store"
}