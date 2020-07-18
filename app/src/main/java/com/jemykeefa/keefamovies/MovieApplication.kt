package com.jemykeefa.keefamovies

import android.app.Application
import com.jemykeefa.keefamovies.di.component.AppComponent
import com.jemykeefa.keefamovies.di.component.DaggerAppComponent
import com.jemykeefa.keefamovies.di.modules.AppModule

class MovieApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        buildComponent()
    }

    private fun buildComponent() {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }
}