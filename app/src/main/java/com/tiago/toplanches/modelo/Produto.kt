package com.tiago.toplanches.modelo

import androidx.annotation.DrawableRes

class Produto (
    val nome : String,
    val preco: String,
    @DrawableRes val image: Int
)

