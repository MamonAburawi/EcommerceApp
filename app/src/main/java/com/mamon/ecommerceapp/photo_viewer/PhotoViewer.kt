package com.mamon.ecommerceapp.photo_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamon.ecommerceapp.R
import com.mamon.ecommerceapp.databinding.PhotoViewerBinding
import com.mamon.ecommerceapp.utils.getProduct
import com.mamon.ecommerceapp.utils.getSelectedImage

class PhotoViewer : Fragment() {

    private lateinit var binding: PhotoViewerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = PhotoViewerBinding.inflate(inflater,container,false)

        val image = getSelectedImage()!!
        binding.photoView.setImageResource(image)

        return binding.root
    }


}