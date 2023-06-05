package com.mamon.ecommerceapp.utils

import com.mamon.ecommerceapp.R
import com.mamon.ecommerceapp.data.Brand
import com.mamon.ecommerceapp.data.Product


val brandsList = listOf(
    Brand("1","BEATS", R.drawable.ic_beats),
    Brand("2","JBL", R.drawable.ic_jbl),
    Brand("3","AKG", R.drawable.ic_akg)
)


val productColors = mapOf(
    "meteorite" to "#402373",
    "redViolet" to "#E00F83",
    "pictonBlue" to "#2AC6EE"
)


private val listofImages = arrayListOf(R.drawable.product_1,R.drawable.product_2,R.drawable.product_3,R.drawable.product_4,R.drawable.product_5)


val productsList = listOf(
    Product("1","1","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",2.5F,245F, productColors.map { it.value }, listofImages.shuffled(), polygonalColor = "#6D3CC4"),
    Product("2","2","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",1.0F,600F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#6D3CC4"),
    Product("3","3","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.0F,780F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#E00F37"),
    Product("4","4","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.0F,50F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#E00F37"),
    Product("5","5","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.5F,960F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#DA3985")
    ,

    Product("6","6","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.0F,50F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#E00F37",isLiked = true),
    Product("7","7","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.5F,480F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#DA3985")

    ,

    Product("8","8","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.0F,50F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#E00F37"),
    Product("9","9","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.5F,480F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#DA3985",
    )

    ,

    Product("10","10","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.0F,50F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#E00F37"),
    Product("11","11","Input Type: 3.5mm stereo jack\n" +
            "Other Features: Bluetooth, Foldable, Noise Isolation, Stereo, Stereo Bluetooth, Wireless\n" +
            "Form Factor: On-Ear\n" +
            "Connections: Bluetooth, Wireless\n" +
            "Speaker Configurations: Stereo ",4.5F,480F, productColors.map { it.value },listofImages.shuffled(), polygonalColor = "#DA3985",isLiked = true)

)