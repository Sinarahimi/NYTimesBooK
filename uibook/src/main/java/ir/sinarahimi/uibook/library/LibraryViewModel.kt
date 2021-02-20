package ir.sinarahimi.uibook.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.usecase.GetBooksUseCase
import ir.sinarahimi.domain.usecase.RefreshBooksUseCase
import ir.sinarahimi.presentation.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Sina Rahimi on 2/17/2021.
 */
class LibraryViewModel(
    private val refreshBooksUseCase: RefreshBooksUseCase,
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {

    private var _refreshEvent: MutableLiveData<Event<List<ModelNYTimes.Book>>> = MutableLiveData()
    val refreshEvent: LiveData<Event<List<ModelNYTimes.Book>>> = _refreshEvent

    private var _successEvent: MutableLiveData<Event<String>> = MutableLiveData()
    val successEvent: LiveData<Event<String>> = _successEvent

    private var _errorEvent: MutableLiveData<Event<Int>> = MutableLiveData()
    val errorEvent: LiveData<Event<Int>> = _errorEvent

    init {
        refresh()
        viewModelScope.launch {
            getBooksUseCase.execute(Unit).collect {
                _refreshEvent.value = Event(it)
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            val networkResponse = refreshBooksUseCase.execute(Unit)
            when (networkResponse) {
                is NetworkResponse.Success -> _successEvent.value = Event("Books Updated")
                is NetworkResponse.Failure -> _errorEvent.value = Event(networkResponse.code)
                is NetworkResponse.Error -> {
                    //You can send message here with LiveData to your UI
                }
            }
        }
    }
}