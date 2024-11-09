package com.example.cryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Cryptocurrency

class CryptocurrencyAdapter(private var coinList: List<Cryptocurrency>) :
    RecyclerView.Adapter<CryptocurrencyAdapter.CoinViewHolder>() {

    // Thiết lập dữ liệu cho các thành phần trong item layout
    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val coinAmountTextView: TextView = itemView.findViewById(R.id.amountTxt)
        val coinBalanceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val coinChangeTextView: TextView = itemView.findViewById(R.id.percentTxt)
        val coinImageView: ImageView = itemView.findViewById(R.id.pic)
        val coinMarketCapTextView: TextView = itemView.findViewById(R.id.textViewMarketCap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cryptocurrency, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]

        //set up data for component in item layout
        holder.coinNameTextView.text = coin.name
        holder.coinAmountTextView.text = String.format("%.2f %s", coin.amount, coin.symbol)
        holder.coinBalanceTextView.text = String.format("$%,.2f", coin.price)
        holder.coinChangeTextView.text = String.format("%.2f%%", coin.percentChange)
        holder.coinImageView.setImageResource(coin.imageResource)
        holder.coinMarketCapTextView.text = String.format("$%,.2f", coin.marketCap)
    }

    override fun getItemCount(): Int = coinList.size
    //update newData from new Cryptocurrency
    fun updateData(newCoinList: List<Cryptocurrency>) {
        coinList = newCoinList
        notifyDataSetChanged()
    }
}
