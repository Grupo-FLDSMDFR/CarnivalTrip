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
    private var carnival = MutableLiveData<List<CarnivalModel>>()

    init {
        requestCarnival()
    }

    fun getCarnival(): LiveData<List<CarnivalModel>> = carnival

    private fun requestCarnival() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            carnival.value = requestSuspendCarnival()
        }
    }

    private suspend fun requestSuspendCarnival(): List<CarnivalModel> {
        return withContext(Dispatchers.IO) {
            apiService.requestCarnival()
        }
    }
}