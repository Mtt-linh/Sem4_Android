package com.example.assweatherapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assweatherapi.adapter.WeatherAdapter;
import com.example.assweatherapi.model.TemItem;
import com.example.assweatherapi.model.Weather;
import com.example.assweatherapi.network.APIManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
   private RecyclerView rvHour;
   private TextView tvTem ;
   private TextView tvStatus ;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTem = (TextView)findViewById(R.id.tvTem);
        tvStatus= (TextView) findViewById(R.id.tvStatus);

        getHour();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rvHour = (RecyclerView)findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);

    }
    private  void getHour(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);
        service.getHour().enqueue(new Callback<List<Weather>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body()!=null) {
                    List<Weather> listWeather = response.body();
                    WeatherAdapter adapter = new WeatherAdapter(MainActivity.this, listWeather);
                    rvHour.setAdapter(adapter);
                    Weather weather = listWeather.get(0);
                    tvTem.setText(weather.getTemItem().getValue().intValue() + "0");
                    tvStatus.setText(weather.getIconTem());
                }

            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Load fail", Toast.LENGTH_LONG).show();
            }


        });
    }
}