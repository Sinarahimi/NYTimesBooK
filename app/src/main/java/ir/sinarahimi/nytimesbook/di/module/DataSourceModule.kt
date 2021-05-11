package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.sinarahimi.data.datasource.book.BookLocalDataSource
import ir.sinarahimi.data.datasource.book.BookRemoteDataSource
import ir.sinarahimi.network.api.BookApi
import ir.sinarahimi.network.datasource.BookRemoteDataSourceImp
import ir.sinarahimi.persistence.database.dao.BookDao
import ir.sinarahimi.persistence.datasource.BookLocalDataSourceImp
import javax.inject.Singleton

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideBookRemoteDataSource(bookApi: BookApi):BookRemoteDataSource =
        BookRemoteDataSourceImp(bookApi)

    @Singleton
    @Provides
    fun provideBookLocalDataSource(bookDao: BookDao):BookLocalDataSource =
        BookLocalDataSourceImp(bookDao)
}