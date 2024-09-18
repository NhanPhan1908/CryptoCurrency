package com.example.cryptocurrency.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptocurrency.R
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrency.Domain.Cryptocurrency
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DashboardFragment : Fragment() {

    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var coinList: List<Cryptocurrency>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout của Fragment
        val view = inflater.inflate(R.layout.dashboard_fragment, container, false)

        // Tạo dữ liệu mẫu cho danh sách các đồng coin
        coinList = listOf(
            Cryptocurrency("Bitcoin",50000.0, 5.0, 1.45),
            Cryptocurrency("Ethereum",3000.0, -2.5, 10.0),
            Cryptocurrency("Litecoin",200.0, 1.2, 50.0),
            Cryptocurrency("Bitcoin", 50000.0, 5.0, 1.45),
            Cryptocurrency("Ethereum", 3000.0, -2.5, 10.0),
            Cryptocurrency("Litecoin", 200.0, 1.2, 50.0),
            Cryptocurrency("Bitcoin", 50000.0, 5.0, 1.45),
            Cryptocurrency("Ethereum", 3000.0, -2.5, 10.0),
            Cryptocurrency("Litecoin", 200.0, 1.2, 50.0),
            Cryptocurrency("Bitcoin", 50000.0, 5.0, 1.45),
            Cryptocurrency("Ethereum", 3000.0, -2.5, 10.0),
            Cryptocurrency("Litecoin", 200.0, 1.2, 50.0),
        )

        // Thiết lập RecyclerView và Adapter
        recyclerView = view.findViewById(R.id.recyclerView)
        cryptocurrencyAdapter = CryptocurrencyAdapter(coinList)
        recyclerView.adapter = cryptocurrencyAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}


