package ir.sinarahimi.domain.usecase

import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.repository.book.BookRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sina Rahimi on 2/18/2021.
 */
class GetBooksUseCase(
    private val bookRepository: BookRepository
) : UseCase<Unit, Flow<List<ModelNYTimes.Book>>> {

    override suspend fun execute(input: Unit): Flow<List<ModelNYTimes.Book>> {
        return bookRepository.get()
    }
}