package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.sinarahimi.domain.repository.book.BookRepository
import ir.sinarahimi.domain.usecase.GetBooksUseCase
import ir.sinarahimi.domain.usecase.RefreshBooksUseCase
import javax.inject.Singleton

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetBooksUseCase(bookRepository: BookRepository): GetBooksUseCase =
        GetBooksUseCase(bookRepository)

    @Provides
    @Singleton
    fun provideRefreshBooksUseCase(bookRepository: BookRepository): RefreshBooksUseCase =
        RefreshBooksUseCase(bookRepository)
}