package com.example.myspace.di

import com.example.myspace.ui.about_us.AboutUsFragment
import com.example.myspace.ui.gallery.GalleryFragment
import com.example.myspace.ui.home.HomeFragment
import com.example.myspace.ui.mks_online.MksOnline
import com.example.myspace.ui.planets_solarSystem.PlanetsSolarSystem
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilderModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributePlanetsSolarSystemFragment(): PlanetsSolarSystem

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeMksOnlineFragment(): MksOnline

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeGalleryFragment(): GalleryFragment

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeAboutUsFragment(): AboutUsFragment
}