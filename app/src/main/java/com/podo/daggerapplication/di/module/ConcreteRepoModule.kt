package com.podo.daggerapplication.di.module

import com.podo.daggerapplication.repo.RepoImpl
import com.podo.daggerapplication.repo.Repo
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

// якщо є певний інтерфейс і треба провайдити його реалізцію, то треба використовувати @Provides або @Binds
// тому що неможливо заінджектити конструктор інтерфейсу (його не існує)

// краще використовувати @Binds - менше коду і кодогенерації
// при @Binds клас повинен бути абстрактним (тоді і всі методи абстрактні) або інтерфейсом
@Module
interface ConcreteBindRepoModule {
  // в параметрах вказуємо тип, який будемо повертати
  // а вернути ми його можемо, тому що коструктор класу помічений @Inject, тому дагер зможе дістати цей тип
  // по суті ми байндимо тип Repo з RepoImpl. коли граф шукає тип Repo, то буде повертати RepoImpl
  @Binds
  fun bindConcreteModule(repoImpl: RepoImpl): Repo
}

// при @Provides використовуємо просто class, методи повинні мати реалізацію
@Module
class ConcreteProvideRepoModule {

  @Provides
  // метод повертає то й ж тип, що і bindConcreteModule(), тому додана анотація @Named, щоб білдилось і щоб їх розрізняти
  @Named("by provide")
  fun provideConcreteModule(repoImpl: RepoImpl): Repo {
    return repoImpl
  }

  // якщо немає інджекта конструктора, то потрібно самому створювати об'єкт
  // наприклад, коли об'єкт створюється через білдер
  @Provides
  @Named("by provide?")
  fun provideConcreteModule2(): Repo {
    return RepoImpl()
  }
}