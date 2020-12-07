package ziemansoft.ziemapp.coins_onlinemvp.models

import ziemansoft.ziemapp.coinsonline.pojo.CoinPriceInfo

interface MainMetheds {
    fun loadData(coinsInfo: List<CoinPriceInfo>)
}