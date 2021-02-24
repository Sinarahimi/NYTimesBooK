package ir.sinarahimi.nytimesbook.di.module.uibook

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.sinarahimi.uibook.library.LibraryFragment

/**
 * Created by Sina Rahimi on 2/24/2021.
 */
@Module
abstract class LibraryFragmentModule {

    @ContributesAndroidInjector
    abstract fun libraryFragment(): LibraryFragment
}