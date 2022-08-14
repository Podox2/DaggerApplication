package com.podo.daggerapplication.repo

import javax.inject.Inject

class RepoByBinds @Inject constructor(): IRepoByBinds {
  private val repoName: String = "repo by binds"

  override fun getName() = repoName
}