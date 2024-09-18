package com.example.cryptocurrency.ViewModel
import com.example.cryptocurrency.Domain.Cryptocurrency

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CryptocurrencyViewModel : ViewModel() {

    // LiveData to hold the list of cryptocurrencies
    val cryptocurrencyList: MutableLiveData<List<Cryptocurrency>> by lazy {
        MutableLiveData<List<Cryptocurrency>>()
    }

    // Function to update the list of cryptocurrencies
    fun setCryptocurrencyList(cryptos: List<Cryptocurrency>) {
        cryptocurrencyList.value = cryptos
    }
    fun fetchCryptocurrencies() {
        val coinList = listOf(
            Cryptocurrency("Bitcoin", 60230.0, 5.0, 1.45),
            Cryptocurrency("Ethereum", 3000.0, -2.5, 14.5),
            Cryptocurrency("Litecoin", 200.0, 1.2, 57.0),
            Cryptocurrency("Binance Coin", 70330.0, 5.0, 1.45),
            Cryptocurrency("Tether", 3000.0, -4.5, 12.0),
            Cryptocurrency("USD Coin", 200.0, 1.7, 53.0),
            Cryptocurrency("Cardano", 5034.0, 6.0, 1.45),
            Cryptocurrency("Solana", 30340.0, -2.5, 10.0),
            Cryptocurrency("XRP", 2045.0, 1.2, 50.0)
        )
        cryptocurrencyList.postValue(coinList)
    }
}
