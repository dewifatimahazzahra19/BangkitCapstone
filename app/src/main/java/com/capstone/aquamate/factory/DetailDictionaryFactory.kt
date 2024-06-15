package com.capstone.aquamate.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.aquamate.api.ApiService
import com.capstone.aquamate.repository.DetailDictionaryRepository
import com.capstone.aquamate.viewmodel.DetailDictionaryViewModel

class DetailDictionaryFactory (private val apiService: ApiService) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailDictionaryViewModel::class.java) -> {
                DetailDictionaryViewModel(DetailDictionaryRepository(apiService)) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: DetailDictionaryFactory? = null

        @JvmStatic
        fun getInstance(apiService: ApiService): DetailDictionaryFactory {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DetailDictionaryFactory(apiService).also { INSTANCE = it }
            }
        }
    }
}
