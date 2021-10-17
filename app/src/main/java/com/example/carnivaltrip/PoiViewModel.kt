package com.example.carnivaltrip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PoiViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var listPoi = MutableLiveData<List<ListPoi>>()

    init {
        requestCarnival()
    }

    fun getCarnival(): LiveData<List<ListPoi>> = listPoi

    fun requestCarnival() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            listPoi.value = requestSuspendCarnival()
        }
    }

    private suspend fun requestSuspendCarnival(): List<ListPoi> {
        return withContext(Dispatchers.IO) {
            apiService.requestCarnival()
        }
    }
}