package com.podo.daggerapplication.repo

import javax.inject.Inject

class RepoImpl @Inject constructor() : Repo {

  override fun repoName() = "ConcreteRepo"
}