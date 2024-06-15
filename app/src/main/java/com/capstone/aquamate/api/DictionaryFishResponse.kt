package com.capstone.aquamate.api

import com.google.gson.annotations.SerializedName

data class DictionaryFishResponse(

	@field:SerializedName("data")
	val data: DataItemFishDictionary? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class CreatedAt(

	@field:SerializedName("_nanoseconds")
	val nanoseconds: Int? = null,

	@field:SerializedName("_seconds")
	val seconds: Int? = null
)
data class DataItemFishDictionary(

	@field:SerializedName("createdAt")
	val createdAt: CreatedAt? = null,

	@field:SerializedName("fishName")
	val fishName: String? = null,

	@field:SerializedName("fishDesc")
	val fishDesc: String? = null,

	@field:SerializedName("fishImage")
	val fishImage: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("fishLatinName")
	val fishLatinName: String? = null
)



