package com.wwt.nimbleviewing

import android.app.Application
import com.wwt.nimbleviewing.di.remoteModules
import com.wwt.nimbleviewing.di.repositoryModule
import com.wwt.nimbleviewing.di.viewmodelModule
import org.koin.core.context.startKoin

class NimbleviewingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(remoteModules, repositoryModule, viewmodelModule) // TODO: do we need DI yet?
        }
    }
}