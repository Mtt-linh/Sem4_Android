package com.example.assweatherapi.adapter;

import android.app.Activity;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assweatherapi.R;
import com.example.assweatherapi.model.Weather;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {

private Activity activity;
private List<Weather> listWeather;

    public WeatherAdapter(Activity activity, List<Weather> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_time,parent,false);
        WeatherHolder holder = new  WeatherHolder(itemView);
        return  holder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        WeatherHolder wh = (WeatherHolder) holder;
        Weather weather = listWeather.get(position);
        wh.tvTime.setText(convertTime(weather.getDate()));
        wh.tvTem.setText(weather.getTemItem().getValue()+"");
        String url="";
        if (weather.getIcon()<10){
            url="https://developer.accuweather.com/sites/default/files/"+weather.getIcon()+"-s.png";

        }else {
            url="https://developer.accuweather.com/sites/default/files/"+weather.getIcon()+"-s.png";

        }
        Glide.with(activity).load(url).into(wh.ivIcon);
    }

    @Override
    public int getItemCount() {
        return  listWeather.size();
    }

    public  static  class  WeatherHolder extends  RecyclerView.ViewHolder{
        private TextView tvTime;
        private ImageView ivIcon;
        private TextView tvTem;
        public   WeatherHolder( @NonNull View itemView){
            super(itemView);
            tvTime= (TextView)itemView.findViewById(R.id.tvTime);
            ivIcon = (ImageView)itemView.findViewById(R.id.ivIcon);
            tvTem = (TextView) itemView.findViewById(R.id.tvTem);
        }

    }
    public String convertTime(String inputTime){
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);

        }catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
