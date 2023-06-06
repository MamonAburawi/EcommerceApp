package com.mamon.ecommerceapp.home

import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController
import com.mamon.ecommerceapp.*
import com.mamon.ecommerceapp.data.Brand
import com.mamon.ecommerceapp.data.Product
import com.mamon.ecommerceapp.utils.SpaceModel_


class HomeController : TypedEpoxyController<List<Any>>() {

    companion object{
        private const val SPLIT_SIZE = 2 // how many item in each row
    }

    private var brands: List<Brand> = emptyList()
    private var products: List<Product> = emptyList()

    lateinit var clickListener: OnClickListener

    fun putData(list: List<Any>) {
        brands = list.filterIsInstance<Brand>()
        products = list.filterIsInstance<Product>()
        setData(list)
    }

     override fun buildModels(list: List<Any>?){
        createBrandModels()

         add(SpaceModel_()
             .id("space_id")
             .height(140))

        createProductModels()
    }

    private fun createBrandModels() {
        header {
            id("brand_header")
            title("Choose Brand")
        }

        val brandModels = brands.map { brand ->
            BrandBindingModel_()
                .id(brand.id)
                .brand(brand)
                .onItemClicked { v ->
                    clickListener.onBrandClicked(brand)
                }
        }

        // the data will be set in horizontal
        CarouselModel_()
            .id("brand_carousel")
            .models(brandModels)
            .addTo(this)
    }


    private fun createProductModels() {

        header {
            id("product_header")
            title("Choose Product")
        }

        // the data will set in vertical by ability to scrolling horizontal for each row
        val groupedProducts = products.chunked(SPLIT_SIZE)
        groupedProducts.forEachIndexed {  index ,group ->
            val productModels = group.map { data ->
                ProductBindingModel_()
                    .id(data.id)
                    .product(data)
                    .onItemClicked { v ->
                        clickListener.onProductClicked(data)
                    }
                    .onItemLiked { v ->
                        clickListener.onProductLiked(data,index)
                    }
            }
            val carouselId = "product_carousel_${group[0].id}"
            CarouselModel_()
                .id(carouselId)
                .models(productModels)
                .spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / 2 }
                .addTo(this)
        }
    }


    interface OnClickListener {
        fun onBrandClicked(brand: Brand)
        fun onProductClicked(product: Product)
        fun onProductLiked(product: Product,position: Int)
    }

}
