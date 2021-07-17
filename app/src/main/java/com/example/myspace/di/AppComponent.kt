package com.example.myspace.di

import android.app.Application
import com.example.myspace.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        AppModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun provideApplication(app: Application): Builder

        fun build(): AppComponent

    }

}