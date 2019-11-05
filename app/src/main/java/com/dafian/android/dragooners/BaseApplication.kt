package com.dafian.android.dragooners

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@BaseApplication)
            modules(
                appModule,
                dataModule,
                domainModule,
                remoteModule,
                useCaseModule,
                presenterModule
            )
        }
    }
}