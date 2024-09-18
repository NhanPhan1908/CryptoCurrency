package com.example.cryptocurrency.Domain;




data class Cryptocurrency(
    val name: String,
    val price: Double,
    val change: Double,
    val amount: Double,
)

