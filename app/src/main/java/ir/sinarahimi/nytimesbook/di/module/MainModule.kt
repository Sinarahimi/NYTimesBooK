package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.sinarahimi.nytimesbook.di.module.uibook.LibraryFragmentModule
import ir.sinarahimi.uibook.MainActivity

/**
 * Created by Sina Rahimi on 2/24/2021.
 */
//With this we are connecting LibraryFragmentModule
// to the activity’s lifecycle
@Module(includes = [LibraryFragmentModule::class])
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun get(): MainActivity
}