package ziemansoft.ziemapp.coins_onlinemvp.presenters

import android.util.Log
import androidx.annotation.MainThread
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ziemansoft.ziemapp.coins_onlinemvp.api.ApiFactory
import ziemansoft.ziemapp.coins_onlinemvp.models.MainMetheds
import ziemansoft.ziemapp.coinsonline.pojo.CoinPriceInfo
import ziemansoft.ziemapp.coinsonline.pojo.CoinRowInfo
import java.util.concurrent.TimeUnit

class MainPresenter(view: MainMetheds) {
    private val compositeDesposable = CompositeDisposable()
    private val mainPresenter = view



    fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsList(limit = 50)
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") }
            .flatMap { ApiFactory.apiService.getCurrentFullData(fSyms = it) }
            .map { getPriceListFromRowData(it) }
            .delay(30, TimeUnit.SECONDS)
            .repeat()
            .subscribeOn(Schedulers.io())
            .subscribe({
                mainPresenter.loadData(it)
                Log.d("TAG", it.toString())
            }, {
                Log.d("TAG", it.message.toString())
            })
        compositeDesposable.add(disposable)
    }

    private fun getPriceListFromRowData(coinRowInfo: CoinRowInfo): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinRowInfo.coinPriceInfoJsonObject
        if (jsonObject == null) return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result


    }
}