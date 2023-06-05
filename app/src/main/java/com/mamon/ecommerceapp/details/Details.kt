package com.mamon.ecommerceapp.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLayoutChangeListener
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.mamon.ecommerceapp.R
import com.mamon.ecommerceapp.data.Product
import com.mamon.ecommerceapp.databinding.DetailsBinding
import com.mamon.ecommerceapp.utils.*



class Details : Fragment() {

    private lateinit var binding: DetailsBinding
    private lateinit var product: Product
    private val imageSliderAdapter by lazy { ImageSliderAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DetailsBinding.inflate(inflater,container,false)
        binding.fragment = this
        product = getDataFromBundle(Constants.KEY_PRODUCT) as Product
        binding.product = product

       
        setViews()





        return binding.root
    }


    private fun setViews() {
        setImageSliderAdapter()
        setChipGroupColors(product.availableColors)
    }

    fun slideToNextImage(){
        binding.viewPager.slideNextImage()
    }

    fun slideToPreviousImage(){
        binding.viewPager.slideToPreviousImage()
    }


    fun navigateToPrevious(){
        findNavController().navigateUp()
    }

    fun navigateToCart(){
        findNavController().navigate(R.id.action_details_to_cart)
    }

    fun addToCart(){
        showMessage("Add to cart")
    }

    fun buyNow(){
        showMessage("buy now")
    }



    private fun setImageSliderAdapter() {
        imageSliderAdapter.submitList(product.icons)
        imageSliderAdapter.listener = object : ImageSliderAdapter.ImageSlideClickListener{
            override fun onClick(image: Int) {
               navigateDetailsToPhotoViewer(image)
            }
        }
        binding.viewPager.adapter = imageSliderAdapter
    }


    fun setChipGroupColors(colors: List<String?> = emptyList()) {
        binding.colorChip.apply {
            removeAllViews()
            var ind = 1
            for ((k, v) in productColors) {
                val chip = Chip(context)
                chip.id = ind
                chip.tag = k


                chip.initChip(v)

                if (colors.contains(k)) {
                    chip.isChecked = true
                    // add your color to list
//                    colorsList.add(chip.tag.toString())
                }

                /** select color button **/
                chip.setOnCheckedChangeListener { buttonView, isChecked ->
                    val tag = buttonView.tag.toString()
                    if (!isChecked) {
                        chip.onUnSelectedChip()
                        showMessage("un selected")
                        // remove color (tag) from list
                    } else {
                        chip.onSelectedChip()
                        binding
                        showMessage("selected")
                        // add color (tag) from the list
                    }
                }
                addView(chip)
                ind++
            }
            invalidate()
        }
    }



}