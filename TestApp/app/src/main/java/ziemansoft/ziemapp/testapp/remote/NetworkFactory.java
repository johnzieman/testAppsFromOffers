package ziemansoft.ziemapp.testapp.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkFactory {
    private static NetworkFactory networkFactory;
    private Retrofit retrofit;
    private final String BASE_URL = "http://click-safety.com/";

    public static NetworkFactory getnetworkFactory() {
        if (networkFactory == null) {
            networkFactory = new NetworkFactory();
        }
        return networkFactory;
    }

    public NetworkFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public NetworkService getNetworkFactoryService(){
        return retrofit.create(NetworkService.class);
    }}

