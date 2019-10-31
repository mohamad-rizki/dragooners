package com.dafian.android.dragooners

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin(
            this, listOf(
                appModule,
                dataModule,
                domainModule,
                remoteModule,
                useCaseModule,
                presenterModule
            )
        )
    }
}