package ir.sinarahimi.nytimesbook.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.hosseinabbasi.mvvm.di.qualifier.ViewModelKey
import ir.sinarahimi.presentation.ViewModelFactory
import ir.sinarahimi.uibook.library.LibraryViewModel


/**
 * Created by Sina Rahimi on 2/21/2021.
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LibraryViewModel::class)
    internal abstract fun bindLibraryViewModel(viewModel: LibraryViewModel): ViewModel
}