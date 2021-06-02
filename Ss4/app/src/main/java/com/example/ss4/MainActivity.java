package com.example.ss4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B1
        final  String[] datas = {"apple","iphone","samsung", "LG","Mokia","Sony","Toshiba","Toyota","Huyndai","Hp","Htc","Oppo"};
        //B2
        ArrayAdapter<String >  arrayAdapter= new ArrayAdapter<>(
                this,android.R.layout.simple_list_item1, datas
        );
        //B3
        ListView lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(arrayAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String data = datas[position];
                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
            }
        });
    }
}