package ir.sinarahimi.domain.usecase

import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.repository.book.BookRepository

/**
 * Created by Sina Rahimi on 2/18/2021.
 */
class RefreshBooksUseCase(
    private val bookRepository: BookRepository
    ): UseCase<Unit, NetworkResponse<List<ModelNYTimes.Book>>> {

    override suspend fun execute(input: Unit): NetworkResponse<List<ModelNYTimes.Book>> {
        return bookRepository.refresh()
    }
}