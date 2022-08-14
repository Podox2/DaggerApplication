package com.podo.daggerapplication.repo

import javax.inject.Inject

class RepoByConstructor @Inject constructor() {
  val repoName: String = "repo by constructor"
}