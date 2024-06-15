package com.capstone.aquamate.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capstone.aquamate.api.DataItemFishDictionary
import com.capstone.aquamate.R
import com.capstone.aquamate.databinding.ActivityItemFishDictionaryBinding
import com.squareup.picasso.Picasso

class FishDictionaryAdapter : ListAdapter<DataItemFishDictionary, FishDictionaryAdapter.FishDictionaryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishDictionaryViewHolder {
        val binding = ActivityItemFishDictionaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FishDictionaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FishDictionaryViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class FishDictionaryViewHolder(private val binding: ActivityItemFishDictionaryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fishItem: DataItemFishDictionary) {
            binding.apply {
                tvFishName.text = fishItem.fishName
                tvFishLatinName.text = fishItem.fishLatinName
                tvFishDescription.text = fishItem.fishDesc
                Picasso.get().load(fishItem.fishImage).into(imageFish)

                root.setOnClickListener {
                    // Implement item click listener if needed
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DataItemFishDictionary>() {
        override fun areItemsTheSame(oldItem: DataItemFishDictionary, newItem: DataItemFishDictionary): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItemFishDictionary, newItem: DataItemFishDictionary): Boolean {
            return oldItem == newItem
        }
    }
}