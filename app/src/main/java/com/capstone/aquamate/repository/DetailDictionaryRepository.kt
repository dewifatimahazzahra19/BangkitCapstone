package com.capstone.aquamate.repository

import com.capstone.aquamate.api.ApiService
import com.capstone.aquamate.api.DetailDictionaryResponse

class DetailDictionaryRepository (private val apiService: ApiService) {
    suspend fun getDictionaryDetail(dictionaryId: String, token: String): DetailDictionaryResponse {
        return apiService.getDictionaryDetail(dictionaryId, token)
    }
}