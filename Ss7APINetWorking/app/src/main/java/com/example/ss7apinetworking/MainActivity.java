package com.example.ss7apinetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvDate, tvTitle, tvContent;
    ImageView ivCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        tvDate = findViewById(R.id.tvDate);
        ivCover = findViewById(R.id.ivCover);


        getData();
        Log.d("TAG", "onCreate(getData()):  ");
        getListData();
        Log.d("TAG", "onCreate(getListData()):  ");


    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);

        service.getItemData().enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
//                Log.d("MainActivity", "onResponse:   " + response.body());

                if (response.body()==null){
                    return;
                }
                Item model = response.body();

                Log.d("MainActivity", "onResponse :" + model.getTitle());
                Log.d("MainActivity", "onResponse :" + model.getContent());
                Log.d("MainActivity", "onResponse :" + model.getDate());
                Log.d("MainActivity", "onResponse :" + model.getImage());

                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getContent().getDescription());
                Glide.with(MainActivity.this).load(model.getImage()).into(ivCover);//caau leenhj tawng toocs load


            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t);
            }
        });
    }

    private void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> list = response.body();
                //4 step with recycler view 
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }
}