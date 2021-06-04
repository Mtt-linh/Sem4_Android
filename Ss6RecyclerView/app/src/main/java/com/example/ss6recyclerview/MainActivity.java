package com.example.ss6recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ss6recyclerview.adapter.ContactAdapter;
import com.example.ss6recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapter.IOnClickAdapter {
List<Contact> listData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b1: datasource
        initData();

        //b2: Adapter
        ContactAdapter adapter = new ContactAdapter(this,listData);

        //B7: start register event onclick
        adapter.registerClick(this);

        //b3:layoutManager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        //b4
        RecyclerView rvContact = findViewById(R.id.rvContact);
        rvContact.setLayoutManager(layoutManager);
        rvContact.setAdapter(adapter);
    }

    private void  initData(){
        //seeding data
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));
        listData.add(new Contact("Tran Tien Dung","0763465563",R.drawable.male01));

    }
    private  void gotoDetail(String name){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("NAME", name);
        startActivity(intent);
    }
    //B6.1:
    @Override
    public void onClickEdit(int position) {
        Contact model = listData.get(position);
        gotoDetail(model.getName());
    }
//B6.2
    @Override
    public void onClickItem(int position) {
        Contact model = listData.get(position);
        gotoDetail(model.getName());
    }
}