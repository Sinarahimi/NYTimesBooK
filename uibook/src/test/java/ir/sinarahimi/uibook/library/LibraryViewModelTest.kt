package ir.sinarahimi.uibook.library

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.usecase.GetBooksUseCase
import ir.sinarahimi.domain.usecase.RefreshBooksUseCase
import ir.sinarahimi.presentation.Event
import ir.sinarahimi.uibook.CoroutinesTestRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Sina Rahimi on 3/6/2021.
 */
class LibraryViewModelTest {

    //It helps to swap the background executor used by the architecture components
    // with different one that executes each task synchronously.
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var refreshBooksUseCase: RefreshBooksUseCase

    @MockK
    lateinit var getBooksUseCase: GetBooksUseCase

    lateinit var viewModel: LibraryViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = LibraryViewModel(refreshBooksUseCase, getBooksUseCase)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun refresh_success() = runBlockingTest {
        val books = listOf<ModelNYTimes.Book>()
        val networkResponse = NetworkResponse.Success(books)



        coEvery { refreshBooksUseCase.execute(Unit) } returns networkResponse
        coEvery { getBooksUseCase.execute(Unit) } returns flows()

        viewModel.refresh()

        val valueSuccess = viewModel.successEvent.value?.getContentIfNotHandled()
        val valueBooks = viewModel.refreshEvent.value?.getContentIfNotHandled()

        assertEquals(valueBooks, Event(books).getContentIfNotHandled())
        assertEquals(valueSuccess, Event<String>("Books Updated").getContentIfNotHandled())
    }

    fun flows() = flow<List<ModelNYTimes.Book>> {
        val books = listOf<ModelNYTimes.Book>()
        emit(books)
    }
}