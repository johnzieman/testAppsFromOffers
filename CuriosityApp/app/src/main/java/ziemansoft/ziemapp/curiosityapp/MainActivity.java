package ziemansoft.ziemapp.curiosityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import ziemansoft.ziemapp.curiosityapp.networkUtils.LinkData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONObject jsonObject = LinkData.getJsonObjectFromNetwork();
        if (jsonObject == null) {
            Log.d("MyResult", "not working");
        } else {
            Log.d("MyResult", "working");

        }
    }
}