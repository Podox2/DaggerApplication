package com.podo.daggerapplication.concrete_approach.di

import com.podo.daggerapplication.concrete_approach.repo.RepoImpl
import com.podo.daggerapplication.concrete_approach.repo.IRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

// якщо є певний інтерфейс і треба провайдити його реалізцію, то треба використовувати @Provides або @Binds
// бо не можна заінджектити конструктор інтерфейсу (його не існує)

// краще використовувати @Binds - менше коду і кодогенерації
// при @Binds клас повинен бути абстрактним (тоді і всі методи абстрактні) або інтерфейсом
@Module
interface ConcreteBindRepoModule {
  // в параметрах вказуємо тип, який будемо повертати
  // а вернути ми його можемо, тому що коструктор класу помічений @Inject, тому дагер зможе дістати цей тип
  @Binds
  fun bindConcreteModule(repoImpl: RepoImpl): IRepo
}


// при @Provides використовуємо просто class, методи повинні мати реалізацію
@Module
class ConcreteProvideRepoModule {

  @Provides
  // метод повертає то й ж тип, що і bindConcreteModule(), тому додана анотація @Named, щоб білдилось і щоб їх розрізняти
  @Named("by provide")
  fun provideConcreteModule(repoImpl: RepoImpl): IRepo {
    return repoImpl
  }

  // не знаю чи це адекватно
  @Provides
  @Named("by provide?")
  fun provideConcreteModule2(): IRepo {
    return RepoImpl()
  }
}