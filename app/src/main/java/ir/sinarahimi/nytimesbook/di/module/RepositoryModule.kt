package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.Provides
import ir.sinarahimi.data.datasource.book.BookLocalDataSource
import ir.sinarahimi.data.datasource.book.BookRemoteDataSource
import ir.sinarahimi.data.repository.book.BookRepositoryImp
import ir.sinarahimi.domain.repository.book.BookRepository

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
class RepositoryModule {

    @Provides
    fun provideBookRepository(
        bookLocalDataSource: BookLocalDataSource,
        bookRemoteDataSource: BookRemoteDataSource
    ): BookRepository =
        BookRepositoryImp(bookLocalDataSource, bookRemoteDataSource)
}