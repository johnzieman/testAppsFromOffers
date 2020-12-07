package ziemansoft.ziemapp.coins_onlinemvp.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ziemansoft.ziemapp.coins_onlinemvp.api.NetworkService

object ApiFactory {
    private const val BASE_URL = "https://min-api.cryptocompare.com/"
    val BASE_IMAGE_URL = "https://cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(NetworkService::class.java)
}