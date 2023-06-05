package com.mamon.ecommerceapp.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamon.ecommerceapp.databinding.CartBinding

class Cart : Fragment() {

    private lateinit var binding: CartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = CartBinding.inflate(inflater,container,false)


        return binding.root
    }


}