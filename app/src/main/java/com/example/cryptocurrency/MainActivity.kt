package com.example.cryptocurrency

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import com.example.cryptocurrency.Domain.Cryptocurrency

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment)

        // Setup RecyclerView and Adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        cryptocurrencyAdapter = CryptocurrencyAdapter(emptyList())
        recyclerView.adapter = cryptocurrencyAdapter

        // Observe data from ViewModel
        cryptocurrencyViewModel.cryptocurrencyList.observe(this, Observer { coinList ->
            // Update adapter with the new data
            cryptocurrencyAdapter.updateData(coinList)
        })

        // Fetch the cryptocurrency data in the ViewModel
        cryptocurrencyViewModel.fetchCryptocurrencies()

    }

}






