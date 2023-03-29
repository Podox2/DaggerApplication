package com.podo.daggerapplication.repo

import com.podo.daggerapplication.data.Person
import javax.inject.Inject

class RepoImpl @Inject constructor(
  val person: Person
) : Repo {

  override fun repoName() = "ConcreteRepo"
}