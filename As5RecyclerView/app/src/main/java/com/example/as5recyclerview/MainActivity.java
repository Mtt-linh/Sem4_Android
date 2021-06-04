package com.example.as5recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem {

    List<Product> listProduct = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //B1 : Data source
        initData();
        //B2 Adapter
        ProductAdapter adapter = new ProductAdapter(this,listProduct,this);

        //B3 LayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        //B4 RecyclerView
        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);


    }
    private  void initData(){
        listProduct.add(new Product("Fashion 1","love shift 1","900000",R.drawable.fs1));
        listProduct.add(new Product("Fashion 2","love shift 2","900000",R.drawable.fs2));
        listProduct.add(new Product("Fashion 3","love shift 3","900000",R.drawable.fs3));
        listProduct.add(new Product("Fashion 4","love shift 4","900000",R.drawable.fs4));
        listProduct.add(new Product("Fashion 5","love shift 5","900000",R.drawable.fs5));
        listProduct.add(new Product("Fashion 6","love shift 6","900000",R.drawable.fs6));
        listProduct.add(new Product("Fashion 7","love shift 7","900000",R.drawable.fs7));

    }
    public void onClickItem( int position){
        Product product = listProduct.get(position);
        Toast.makeText(this,product.getTitle(),Toast.LENGTH_SHORT).show();
    }
}