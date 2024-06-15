package com.capstone.aquamate.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capstone.aquamate.api.ApiConfig
import com.capstone.aquamate.api.DictionaryFishResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DictionaryRepository {

    suspend fun getDictionaryFish(token: String, page: Int? = null, size: Int? = null): LiveData<DictionaryFishResponse> {
        val responseLiveData = MutableLiveData<DictionaryFishResponse>()

        ApiConfig.apiService.getDictionaryFish(token, page, size).enqueue(object : Callback<DictionaryFishResponse> {
            override fun onResponse(call: Call<DictionaryFishResponse>, response: Response<DictionaryFishResponse>) {
                if (response.isSuccessful) {
                    responseLiveData.value = response.body()
                    Log.d("DictionaryRepository", "Request success: ${responseLiveData.value}")
                } else {
                    val errorResponse = response.errorBody()?.string() ?: "Unknown error"
                    Log.e("DictionaryRepository", "Request failed: $errorResponse")
                    responseLiveData.value = null
                }
            }

            override fun onFailure(call: Call<DictionaryFishResponse>, t: Throwable) {
                Log.e("DictionaryRepository", "Request failed: ${t.message}")
                responseLiveData.value = null
            }
        })

        return responseLiveData
    }
}
