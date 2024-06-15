package com.capstone.aquamate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.aquamate.api.DetailDictionaryResponse
import com.capstone.aquamate.repository.DetailDictionaryRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetailDictionaryViewModel(private val repository: DetailDictionaryRepository) : ViewModel() {

    private val _dictionaryDetail = MutableLiveData<DetailDictionaryResponse>()
    val dictionaryDetail: LiveData<DetailDictionaryResponse> get() = _dictionaryDetail

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getDictionaryDetail(dictionaryId: String, token: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDictionaryDetail(dictionaryId, token)
                if (!response.error) {
                    _dictionaryDetail.value = response
                } else {
                    _errorMessage.value = response.message ?: "Unknown error occurred"
                }
            } catch (e: HttpException) {
                _errorMessage.value = "HTTP error occurred: ${e.message()}"
            } catch (e: Exception) {
                _errorMessage.value = "Failed to fetch dictionary detail: ${e.message}"
            }
        }
    }
}
