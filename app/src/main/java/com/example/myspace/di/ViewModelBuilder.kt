package com.example.myspace.di

import androidx.lifecycle.ViewModelProvider
import com.example.myspace.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelBuilder {
    @ActivityScoped
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}