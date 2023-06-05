package com.mamon.ecommerceapp.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mamon.ecommerceapp.databinding.SplashBinding
import com.mamon.ecommerceapp.utils.navigateSplashToHome
import com.ncorti.slidetoact.SlideToActView

class Splash : Fragment() {

    private lateinit var binding: SplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = SplashBinding.inflate(inflater,container,false)

        setViews()

        return binding.root
    }

    private fun setViews() {
        setSwipe()
    }



    private fun setSwipe(){
        /** swipe **/
        binding.swipe.onSlideCompleteListener = object: SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                navigateSplashToHome()
            }
        }
    }


}