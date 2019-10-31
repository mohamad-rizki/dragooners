package com.dafian.android.dragooners

import com.dafian.android.dragooners.data.repository.*
import com.dafian.android.dragooners.data.source.*
import com.dafian.android.dragooners.domain.repository.*
import com.dafian.android.dragooners.presentation.ui.armor.ArmorPresenter
import com.dafian.android.dragooners.presentation.ui.charm.CharmPresenter
import com.dafian.android.dragooners.presentation.ui.item.ItemPresenter
import com.dafian.android.dragooners.presentation.ui.skill.SkillPresenter
import com.dafian.android.dragooners.presentation.ui.weapon.WeaponPresenter
import com.dafian.android.dragooners.remote.service.NetworkComponent
import com.dafian.android.dragooners.remote.source.*
import com.dafian.android.dragooners.usecase.*
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

}

val dataModule = module {

    factory<ArmorRepository> { ArmorRepositoryImpl(get()) }

    factory<CharmRepository> { CharmRepositoryImpl(get()) }

    factory<ItemRepository> { ItemRepositoryImpl(get()) }

    factory<SkillRepository> { SkillRepositoryImpl(get()) }

    factory<WeaponRepository> { WeaponRepositoryImpl(get()) }
}

val domainModule = module {

}

val remoteModule = module {

    single { NetworkComponent.makeRestService(get(), get(), get()) }

    single { NetworkComponent.makeClientService(get(), get()) }

    single { NetworkComponent.makeLoggingInterceptor() }

    single { NetworkComponent.makeObjectMapper() }

    single { NetworkComponent.makeCache(get()) }

    factory<ArmorRemoteDataSource> { ArmorRemoteDataSourceImpl(get()) }

    factory<CharmRemoteDataSource> { CharmRemoteDataSourceImpl(get()) }

    factory<ItemRemoteDataSource> { ItemRemoteDataSourceImpl(get()) }

    factory<SkillRemoteDataSource> { SkillRemoteDataSourceImpl(get()) }

    factory<WeaponRemoteDataSource> { WeaponRemoteDataSourceImpl(get()) }
}

val useCaseModule = module {

    single { GetArmorAllUseCase(get()) }

    single { GetCharmAllUseCase(get()) }

    single { GetItemAllUseCase(get()) }

    single { GetSkillAllUseCase(get()) }

    single { GetWeaponAllUseCase(get()) }
}

val presenterModule = module {

    viewModel { ArmorPresenter(get()) }

    viewModel { CharmPresenter(get()) }

    viewModel { ItemPresenter(get()) }

    viewModel { SkillPresenter(get()) }

    viewModel { WeaponPresenter(get()) }
}