package com.mamon.ecommerceapp.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mamon.ecommerceapp.databinding.ItemImageSliderBinding

class ImageSliderAdapter : ListAdapter<Int, ImageSliderAdapter.ImageViewHolder>(ImageDiffCallback()) {

    lateinit var listener: ImageSlideClickListener

    inner class ImageViewHolder(private val binding: ItemImageSliderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageRes: Int) {

            binding.apply {
                // set data
                image = imageRes

                // onImageClicked
                setOnItemClick {
                    listener.onClick(imageRes)
                }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageSliderBinding.inflate(inflater,parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageRes = getItem(position)
        holder.bind(imageRes)
    }



    class ImageDiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }


    interface ImageSlideClickListener{
        fun onClick(image: Int)
    }


}



