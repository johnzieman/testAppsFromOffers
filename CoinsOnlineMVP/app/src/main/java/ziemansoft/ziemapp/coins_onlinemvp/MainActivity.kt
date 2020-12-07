package ziemansoft.ziemapp.coins_onlinemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ziemansoft.ziemapp.coins_onlinemvp.adapters.CoinsAdapter
import ziemansoft.ziemapp.coins_onlinemvp.models.MainMetheds
import ziemansoft.ziemapp.coins_onlinemvp.presenters.MainPresenter
import ziemansoft.ziemapp.coinsonline.pojo.CoinPriceInfo

class MainActivity : AppCompatActivity(), MainMetheds {
    val mainPresenter = MainPresenter(this)
    val adapter = CoinsAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        mainPresenter.loadData()
    }

    override fun loadData(coinsInfo: List<CoinPriceInfo>) {
        adapter.coinInfoList = coinsInfo
    }
}