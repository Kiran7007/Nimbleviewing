package com.wwt.nimbleviewing

import android.app.Application
import org.koin.core.context.startKoin

class NimbleviewingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(remoteModules, repositoryModule, viewmodelModule) // TODO: do we need DI yet?
        }
    }
}