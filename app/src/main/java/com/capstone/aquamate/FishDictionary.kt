package com.capstone.aquamate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.aquamate.databinding.ActivityFishDictionaryBinding
import com.capstone.aquamate.repository.DictionaryRepository
import com.capstone.aquamate.viewmodel.DictionaryViewModel

class FishDictionary : AppCompatActivity() {

    private lateinit var viewModel: DictionaryViewModel
    private lateinit var binding: ActivityFishDictionaryBinding
    private lateinit var repository: DictionaryRepository
    private lateinit var token: String

    companion object {
        const val FISHDICTIONARY = "fishdictionary"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //repository = injection.provideDictionaryRepository(this)
    }
}
