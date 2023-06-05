package com.mamon.ecommerceapp.utils

import android.graphics.Color
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("setImage")
fun setImage(v: ImageView, image: Int){
    Glide.with(v)
        .load(image)
        .into(v)
}


@BindingAdapter("setRate")
fun setRate(v: RatingBar, rate: Float){
    v.rating = rate
}



@BindingAdapter("setPrice")
fun setPrice(tv: TextView, price: Float){
    tv.text = "$${price}"
}


@BindingAdapter("setPolygonalColor")
fun setPolygonalColor(image: ImageView,color: String){
    image.setColorFilter(Color.parseColor(color))
}


