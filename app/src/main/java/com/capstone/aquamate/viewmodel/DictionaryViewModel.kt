package com.capstone.aquamate.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.aquamate.api.ApiService
import com.capstone.aquamate.api.DictionaryFishResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class DictionaryViewModel(private val apiService: ApiService) : ViewModel() {

    private val _dictionaryLiveData = MutableLiveData<DictionaryFishResponse?>()
    val dictionaryLiveData: LiveData<DictionaryFishResponse?> = _dictionaryLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    companion object {
        const val DICTIONARY_API = "dictionaryapi"
    }

    suspend fun getDictionaryFromApi(token: String, page: Int? = null, size: Int? = null) {
        Log.d(DICTIONARY_API, "Token used for API request: $token")

        apiService.getDictionaryFish("Bearer $token", page, size)
            .enqueue(object : Callback<DictionaryFishResponse> {
                override fun onResponse(
                    call: Call<DictionaryFishResponse>,
                    response: Response<DictionaryFishResponse>
                ) {
                    if (response.isSuccessful) {
                        _dictionaryLiveData.value = response.body()
                        Log.d(DICTIONARY_API, "API response: ${response.body()}")
                    } else {
                        val errorResponse = response.errorBody()?.string() ?: "Unknown error"
                        _errorMessage.value = "Request failed: $errorResponse"
                        Log.e(DICTIONARY_API, "Request failed: $errorResponse")
                    }
                }

                override fun onFailure(call: Call<DictionaryFishResponse>, t: Throwable) {
                    _errorMessage.value = "Request failed: ${t.message}"
                    Log.e(DICTIONARY_API, "Request failed", t)
                }
            })
    }
}
