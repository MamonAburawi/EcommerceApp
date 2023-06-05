package com.mamon.ecommerceapp.news_paper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamon.ecommerceapp.databinding.NewsPaperBinding

class NewsPaper : Fragment() {

    private lateinit var binding: NewsPaperBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = NewsPaperBinding.inflate(inflater,container,false)



        return binding.root
    }



}