package com.mamon.ecommerceapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamon.ecommerceapp.data.CombinedData
import com.mamon.ecommerceapp.data.Brand
import com.mamon.ecommerceapp.data.Product
import com.mamon.ecommerceapp.utils.brandsList
import com.mamon.ecommerceapp.utils.productsList
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private val _brands = MutableLiveData<List<Brand>>()
    val brands: LiveData<List<Brand>> = _brands

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _combinedLiveData = MutableLiveData<CombinedData>()
    val combinedLiveData: LiveData<CombinedData> = _combinedLiveData


    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val brandsDeferred = async { fetchBrands() }
            val productsDeferred = async { fetchProducts() }

            // here you will wait until all data fetched then combined Live Data will be updated
            val brands = brandsDeferred.await()
            val products = productsDeferred.await()

            _brands.value = brands
            _products.value = products

            val combinedData = CombinedData(brands, products)
            _combinedLiveData.value = combinedData
        }
    }


    private suspend fun fetchBrands(): List<Brand> {
        // Fetch data1 asynchronously
        // ..
        delay(500)
        return brandsList
    }

    private suspend fun fetchProducts(): List<Product> {
        // Fetch data2 asynchronously
        // ...
        return productsList
    }



}