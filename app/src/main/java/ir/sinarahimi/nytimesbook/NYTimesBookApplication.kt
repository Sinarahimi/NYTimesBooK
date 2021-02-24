package ir.sinarahimi.nytimesbook

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ir.sinarahimi.nytimesbook.di.component.DaggerAppComponent

/**
 * Created by Sina Rahimi on 2/21/2021.
 */
class NYTimesBookApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}