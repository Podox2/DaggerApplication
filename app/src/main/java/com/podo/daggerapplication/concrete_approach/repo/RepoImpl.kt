package com.podo.daggerapplication.concrete_approach.repo

import javax.inject.Inject

class RepoImpl @Inject constructor() : IRepo {

  override fun repoName() = "ConcreteRepo"
}