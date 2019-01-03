package com.dafian.android.dragooners.di

import com.dafian.android.dragooners.domain.repository.*
import org.koin.dsl.module.module

val appModule = module {

}

val networkModule = module {

    single { NetworkComponent.makeRestService(get(), get(), get()) }

    single { NetworkComponent.makeClientService(get(), get()) }

    single { NetworkComponent.makeLoggingInterceptor() }

    single { NetworkComponent.makeObjectMapper() }

    single { NetworkComponent.makeCache(get()) }
}

val localModule = module {

}

val domainModule = module {

    single<ArmorRepository> { ArmorRepositoryImpl(get()) }

    single<CharmRepository> { CharmRepositoryImpl(get()) }

    single<ItemRepository> { ItemRepositoryImpl(get()) }

    single<SkillRepository> { SkillRepositoryImpl(get()) }

    single<WeaponRepository> { WeaponRepositoryImpl(get()) }
}

val presenterModule = module {

}