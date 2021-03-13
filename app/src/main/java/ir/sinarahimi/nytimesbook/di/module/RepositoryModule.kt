package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.sinarahimi.data.datasource.book.BookLocalDataSource
import ir.sinarahimi.data.datasource.book.BookRemoteDataSource
import ir.sinarahimi.data.repository.book.BookRepositoryImp
import ir.sinarahimi.domain.repository.book.BookRepository

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideBookRepository(
        bookLocalDataSource: BookLocalDataSource,
        bookRemoteDataSource: BookRemoteDataSource
    ): BookRepository =
        BookRepositoryImp(bookLocalDataSource, bookRemoteDataSource)
}