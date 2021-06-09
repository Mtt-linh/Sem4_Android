package com.example.ss7apinetworking;

import java.util.List;

import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
   String SERVER_URL = "https://api-demo-anhth.herokuapp.com/";

@GET("data.json")
    Call<Item> getItemData();
//Call<Item> getItemData(@Query("page") int page, @Query("limit" ) String limit);
@GET("datas.json")
    Call<List<Item>> getListData();

}
