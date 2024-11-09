package com.example.cryptocurrency.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.api.RetrofitInstance
import com.example.cryptocurrency.domain.Cryptocurrency
import com.example.cryptocurrency.domain.CoinMarketCapResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class CryptocurrencyViewModel : ViewModel() {

    val cryptocurrencyList: MutableLiveData<List<Cryptocurrency>> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    init {
        fetchCryptocurrencies()
    }

    fun fetchCryptocurrencies() {
        viewModelScope.launch {
            try {
                val response: CoinMarketCapResponse = RetrofitInstance.api.getCryptocurrencyList()
                //call API from Retrofit Instance
                val cryptos = response.data.map { apiCrypto ->
                    //change API data to Cryptocurrency object
                    Cryptocurrency(
                        name = apiCrypto.name,
                        price = apiCrypto.quote.USD.price,
                        percentChange = apiCrypto.quote.USD.percent_change_24h, // Sử dụng thuộc tính đã được định nghĩa
                        symbol = apiCrypto.symbol,
                        marketCap = apiCrypto.quote.USD.market_cap, // Sử dụng thuộc tính đã được định nghĩa
                        quote = apiCrypto.quote,
                        amount = 0.0
                    )
                }
                cryptocurrencyList.postValue(cryptos)
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }
}


