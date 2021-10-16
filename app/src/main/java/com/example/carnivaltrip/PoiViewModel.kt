package com.example.carnivaltrip

import androidx.lifecycle.*
import com.example.carnivaltrip.ListPoi
import com.example.carnivaltrip.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch

class PoiViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var carnival = MutableLiveData<List<ListPoi>>()

    init {
        requestCarnival()
    }

    fun getCarnival() : LiveData<List<ListPoi>> = carnival

    fun requestCarnival() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            carnival.value = requestSuspendCarnival()
        }
    }

    private suspend fun requestSuspendCarnival(): List<ListPoi> {
        return withContext(Dispatchers.IO) {
            apiService.requestCarnival()
        }
    }
}