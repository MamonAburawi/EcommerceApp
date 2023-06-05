package com.mamon.ecommerceapp.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamon.ecommerceapp.data.Brand
import com.mamon.ecommerceapp.data.Product
import com.mamon.ecommerceapp.databinding.HomeBinding
import com.mamon.ecommerceapp.utils.*

class Home : Fragment() {

    private lateinit var binding: HomeBinding
    private lateinit var viewModel: HomeViewModel

    private val homeController by lazy { HomeController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = HomeBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]


        setViews()
        setObserves()


        return binding.root
    }

    private fun setObserves() {
        viewModel.apply {


            combinedLiveData.observe(viewLifecycleOwner){
                if (it != null){
                    homeController.putData(it.brands + it.products)
                }
            }


        }
    }



    private fun setAdapter(){

        homeController.clickListener = object: HomeController.OnClickListener{
            override fun onBrandClicked(brand: Brand) {
                showMessage(brand.name)
            }
            override fun onProductClicked(product: Product) {
                navigateHomeToDetails(product)
            }
            override fun onProductLiked(product: Product,position: Int) {
                val isLiked = product.isLiked
                if (isLiked){ showMessage("unLiked") } else{ showMessage("liked") }
            }
        }


        binding.rvHome.setMargin(0,0,0, 75)
        binding.rvHome.adapter = homeController.adapter



    }


    private fun setViews() {

        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this@Home

        setAdapter()
        setButtons()
    }

    private fun setButtons(){
        binding.apply {
            /** button menu **/
            btnMenu.setOnClickListener {
                showMessage("menu")
            }

            /** button search **/
            btnSearch.setOnClickListener {
                showMessage("search")
            }
        }
    }


}