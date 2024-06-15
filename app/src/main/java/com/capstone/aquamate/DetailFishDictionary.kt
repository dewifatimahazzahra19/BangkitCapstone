package com.capstone.aquamate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.capstone.aquamate.api.ApiConfig
import com.capstone.aquamate.databinding.ActivityDetailFishDictionaryBinding
import com.capstone.aquamate.factory.DetailDictionaryFactory
import com.capstone.aquamate.viewmodel.DetailDictionaryViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class DetailFishDictionary : AppCompatActivity() {

//    private lateinit var binding: ActivityDetailFishDictionaryBinding
//    private lateinit var viewModel: DetailDictionaryViewModel
//
//    companion object {
//        private const val DETAIL_DICTIONARY_TAG = "DetailDictionary"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDetailFishDictionaryBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Get dictionaryId and token from intent
//        val dictionaryId = intent.getStringExtra("dictionaryId")
//        val token = intent.getStringExtra("token")
//        Log.d(DETAIL_DICTIONARY_TAG, "Dictionary ID: $dictionaryId, Token: $token")
//
//        if (dictionaryId != null && token != null) {
//            // Initialize ViewModel with custom factory
//            viewModel = ViewModelProvider(
//                this,
//                DetailDictionaryFactory.getInstance(ApiConfig.apiService)
//            ).get(DetailDictionaryViewModel::class.java)
//
//            // Fetch dictionary detail
//            viewModel.getDictionaryDetail(dictionaryId, token)
//
//            // Observe ViewModel data
//            observeViewModel()
//        } else {
//            showToast("Invalid dictionary ID or token")
//            Log.e(DETAIL_DICTIONARY_TAG, "Invalid dictionary ID or token")
//            finish()
//        }
//    }
//
//    private fun observeViewModel() {
//        // Observe dictionary details
//        viewModel.dictionaryDetail.observe(this, Observer { dictionaryDetail ->
//            binding.fishName.text = dictionaryDetail.fishName
//            binding.fishLatinName.text = dictionaryDetail.fishLatinName
//            binding.deskripsiDetail.text = dictionaryDetail.fishDesc
//            loadImage(dictionaryDetail.fishImage)
//        })
//
//        // Observe error messages
//        viewModel.errorMessage.observe(this, Observer { errorMessage ->
//            showToast(errorMessage)
//            Log.e(DETAIL_DICTIONARY_TAG, "Error: $errorMessage")
//        })
//    }
//
//    private fun loadImage(photoUrl: String) {
//        Picasso.get()
//            .load(photoUrl)
//            .into(binding.imgPhotos, object : Callback {
//                override fun onSuccess() {
//                    Log.d(DETAIL_DICTIONARY_TAG, "Image loaded successfully")
//                }
//
//                override fun onError(e: Exception?) {
//                    e?.printStackTrace()
//                    Log.e(DETAIL_DICTIONARY_TAG, "Error loading image: ${e?.message}")
//                }
//            })
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//        val token = intent.getStringExtra("token") ?: ""
//        val intent = Intent(this, FishDictionary::class.java).apply {
//            putExtra("token", token)
//        }
//        startActivity(intent)
//        finish()
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                onBackPressed()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
