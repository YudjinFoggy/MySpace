package com.example.myspace.di

import androidx.lifecycle.ViewModel
import com.example.myspace.MainViewModel
import com.example.myspace.ui.about_us.AboutUsFragment
import com.example.myspace.ui.about_us.AboutUsViewModel
import com.example.myspace.ui.gallery.GalleryViewModel
import com.example.myspace.ui.home.HomeViewModel
import com.example.myspace.ui.mks_online.MksOnlineViewModel
import com.example.myspace.ui.planets_solarSystem.PlanetsSolarSystemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeFragmentViewModel(homeFragmentViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlanetsSolarSystemViewModel::class)
    abstract fun bindPlanetsSolarSystemFragmentViewModel(planetsSolarSystemViewModel: PlanetsSolarSystemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MksOnlineViewModel::class)
    abstract fun bindMksOnlineFragmentViewModel(mksOnlineViewModel: MksOnlineViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun bindGalleryFragmentViewModel(galleryViewModel: GalleryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutUsViewModel::class)
    abstract fun bindAboutUsFragmentViewModel(aboutUsViewModel: AboutUsViewModel): ViewModel
}