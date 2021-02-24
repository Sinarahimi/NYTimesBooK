package ir.sinarahimi.nytimesbook.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.sinarahimi.nytimesbook.NYTimesBookApplication
import ir.sinarahimi.nytimesbook.di.module.*
import javax.inject.Singleton

/**
 * Created by Sina Rahimi on 2/21/2021.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainModule::class,
        DataSourceModule::class,
        NetworkModule::class,
        PersistenceModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<NYTimesBookApplication> {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }
}