package com.mamon.ecommerceapp.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamon.ecommerceapp.databinding.AccountBinding

class Account : Fragment() {

    private lateinit var binding: AccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = AccountBinding.inflate(inflater,container,false)



        return binding.root
    }




}