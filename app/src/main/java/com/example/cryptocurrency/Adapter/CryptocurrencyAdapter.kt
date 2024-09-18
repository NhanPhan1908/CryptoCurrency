package com.example.cryptocurrency.Adapter
import com.example.cryptocurrency.Domain.Cryptocurrency
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import android.widget.TextView
import android.widget.ImageView
import android.view.View




class CryptocurrencyAdapter(private var coinList: List<Cryptocurrency>) :
    RecyclerView.Adapter<CryptocurrencyAdapter.CoinViewHolder>() {

    // ViewHolder đại diện cho mỗi item
    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val coinAmountTextView: TextView = itemView.findViewById(R.id.amountTxt)
        val coinBalanceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val coinChangeTextView: TextView = itemView.findViewById(R.id.percentTxt)
        val coinImageView: ImageView = itemView.findViewById(R.id.pic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        // Inflate layout item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cryptocurrency, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]

        // Thiết lập dữ liệu cho các thành phần trong item layout
        holder.coinNameTextView.text = coin.name
        holder.coinAmountTextView.text = String.format("%.2f %s", coin.amount, coin.name)
        holder.coinBalanceTextView.text = String.format("$%,.2f", coin.price)
        holder.coinChangeTextView.text = String.format("%.2f%%", coin.change)

        // Đặt hình ảnh tương ứng
        when (coin.name) {
            "Bitcoin" -> holder.coinImageView.setImageResource(R.drawable.btc)
            "Ethereum" -> holder.coinImageView.setImageResource(R.drawable.eth)
            "Litecoin" -> holder.coinImageView.setImageResource(R.drawable.ltc)
            "Binance Coin" -> holder.coinImageView.setImageResource(R.mipmap.bnb)
            "Tether" -> holder.coinImageView.setImageResource(R.mipmap.tether_round)
            "USD Coin" -> holder.coinImageView.setImageResource(R.mipmap.usdc_round)
            "Cardano " -> holder.coinImageView.setImageResource(R.mipmap.cardano_round)
            "Solana" -> holder.coinImageView.setImageResource(R.mipmap.solana_round)
            "XRP" -> holder.coinImageView.setImageResource(R.drawable.xrp)
        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
    fun updateData(newCoinList: List<Cryptocurrency>) {
        coinList = newCoinList
        notifyDataSetChanged()
    }
}


