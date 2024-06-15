package com.capstone.aquamate.api

import com.google.gson.annotations.SerializedName

data class PredictFishResponse(

	@field:SerializedName("data")
	val data: DataItem? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("explanation")
	val explanation: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)
