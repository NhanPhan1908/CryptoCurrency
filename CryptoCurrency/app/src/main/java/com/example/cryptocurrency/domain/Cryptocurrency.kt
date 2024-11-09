package com.example.cryptocurrency.domain

import com.example.cryptocurrency.R

data class Cryptocurrency(
    val name: String,
    val price: Double,
    val percentChange: Double,
    val symbol: String,
    val marketCap: Double,
    val quote: Quote,
    val amount: Double
) {
    val imageResource: Int
        get() = when (name) {
            "Bitcoin" -> R.drawable.btc
            "Ethereum" -> R.drawable.eth
            "Litecoin" -> R.drawable.ltc
            "Binance Coin" -> R.mipmap.bnb
            "Tether" -> R.mipmap.tether_round
            "USD Coin" -> R.mipmap.usdc_round
            "Cardano" -> R.mipmap.cardano_round
            "Solana" -> R.mipmap.solana_round
            "XRP" -> R.drawable.xrp
            else -> R.drawable.btc
        }
}
