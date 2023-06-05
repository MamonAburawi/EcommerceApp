package com.mamon.ecommerceapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*
import kotlin.collections.ArrayList


@Parcelize
data class Product (
    val id: String = "",
    var title: String = "",
    val description: String = "",
    val rating: Float = 0.0f,
    val price: Float = 0.0f,
    val availableColors: List<String> = ArrayList(),
    val icons: List<Int> = ArrayList(),
    val polygonalColor: String = "",
    @JvmField
    var isLiked: Boolean = false,
    val date: Date = Date()
): Parcelable