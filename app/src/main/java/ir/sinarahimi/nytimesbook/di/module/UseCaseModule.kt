package ir.sinarahimi.nytimesbook.di.module

import dagger.Module
import dagger.Provides
import ir.sinarahimi.domain.repository.book.BookRepository
import ir.sinarahimi.domain.usecase.GetBooksUseCase
import ir.sinarahimi.domain.usecase.RefreshBooksUseCase

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
class UseCaseModule {

    @Provides
    fun provideGetBooksUseCase(bookRepository: BookRepository): GetBooksUseCase =
        GetBooksUseCase(bookRepository)

    @Provides
    fun provideRefreshBooksUseCase(bookRepository: BookRepository): RefreshBooksUseCase =
        RefreshBooksUseCase(bookRepository)
}