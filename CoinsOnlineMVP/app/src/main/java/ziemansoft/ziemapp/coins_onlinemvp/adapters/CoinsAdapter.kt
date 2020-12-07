package ziemansoft.ziemapp.coins_onlinemvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_view_item.view.*
import ziemansoft.ziemapp.coins_onlinemvp.R
import ziemansoft.ziemapp.coinsonline.pojo.CoinPriceInfo

class CoinsAdapter( private val context: Context):RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder>() {

    var coinInfoList = listOf<CoinPriceInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return CoinsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val coin = coinInfoList[position]
        val string: String = context.getString(R.string.last_updated)
        holder.symbols.text = coin.fromSymbols + " / " +coin.toSymbols
        holder.price.text = coin.price.toString() + "$"
        holder.lastUpdate.text= string + " "+coin.getFormattedTime()
        Picasso.get().load(coin.getFullUrl()).into(holder.logoCoin)
    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val logoCoin = itemView.imageView
        val symbols = itemView.textView
        val price = itemView.textView2
        val lastUpdate =  itemView.textView3
    }
}