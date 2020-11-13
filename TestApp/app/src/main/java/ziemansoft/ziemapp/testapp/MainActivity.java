package ziemansoft.ziemapp.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import rx.Scheduler;
import ziemansoft.ziemapp.testapp.pojo.Responce;
import ziemansoft.ziemapp.testapp.remote.NetworkFactory;
import ziemansoft.ziemapp.testapp.remote.NetworkService;

public class MainActivity extends AppCompatActivity {
    private Disposable disposable;
    NetworkFactory networkFactory;
    NetworkService networkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disposable = new CompositeDisposable();
        networkFactory = NetworkFactory.getnetworkFactory();
        networkService = networkFactory.getNetworkFactoryService();


    }

    public void getViewPage(View view) {
        disposable = networkService.getResponceObject("lover").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Responce>() {
                    @Override
                    public void accept(Responce responce) throws Exception {
                        if (responce.isGetBannerContent()) {
                            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                            intent.putExtra("url", responce.getUrlToDisplay());
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Sorry we need to stay safe", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}