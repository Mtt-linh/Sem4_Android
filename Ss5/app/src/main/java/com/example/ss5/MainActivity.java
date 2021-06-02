package com.example.ss5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B1 data source
        initData();

        //B2 Adapter
        ContactAdapter adapter = new ContactAdapter(listContact , this);

        //b3 layout manager
        //
       // RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);

        //B4 Recycler View
        RecyclerView recyclerView = findViewById(R.id.rvContact);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    private void initData() {
        listContact.add(new Contact("Tran Hoai nam", "09876534567", R.drawable.images));
        listContact.add(new Contact("Truonh Triet Han", "096746", R.drawable.triethan));
        listContact.add(new Contact("Hoanh Minh Anh", "09876534567", R.drawable.male01));
        listContact.add(new Contact("Luong The Vinh", "09876534567", R.drawable.male02));
        listContact.add(new Contact("Tran Hoai nam", "09876534567", R.drawable.images));
        listContact.add(new Contact("Truonh Triet Han", "096746", R.drawable.triethan));
        listContact.add(new Contact("Hoanh Minh Anh", "09876534567", R.drawable.male01));
        listContact.add(new Contact("Luong The Vinh", "09876534567", R.drawable.male02));
        listContact.add(new Contact("Tran Hoai nam", "09876534567", R.drawable.images));
        listContact.add(new Contact("Truonh Triet Han", "096746", R.drawable.triethan));
        listContact.add(new Contact("Hoanh Minh Anh", "09876534567", R.drawable.male01));
        listContact.add(new Contact("Luong The Vinh", "09876534567", R.drawable.male02));
        listContact.add(new Contact("Tran Hoai nam", "09876534567", R.drawable.images));
        listContact.add(new Contact("Truonh Triet Han", "096746", R.drawable.triethan));
        listContact.add(new Contact("Hoanh Minh Anh", "09876534567", R.drawable.male01));
        listContact.add(new Contact("Luong The Vinh", "09876534567", R.drawable.male02));


    }
}