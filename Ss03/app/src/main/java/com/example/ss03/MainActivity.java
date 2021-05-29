package com.example.ss03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvHello;
    private static final int REQUEST_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate()");
        Button btClick = (Button) findViewById(R.id.btClick);
        Button btCancel = (Button) findViewById(R.id.btCancel);

        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Chao cac ban");

        btClick.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btClick:
                Log.i("TAG","onClick onClick !!!");
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra(Constant.USER,tvHello.getText().toString());
                intent.putExtra("AGE",30);

//                startActivityForResult(intent.REQUET_CODE);
                break;
            case  R.id.btCancel:
                Log.i("TAG", "Cancel clicked!!!");
                tvHello.setText("Cancel");

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== REQUEST_CODE){
            if(requestCode == Constant.RESULTCODE){
                String text = data.getStringExtra("PROFILE");
                tvHello.setText(text);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy()");
    }
}