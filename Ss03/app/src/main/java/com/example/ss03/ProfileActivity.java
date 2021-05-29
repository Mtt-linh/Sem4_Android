package com.example.ss03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
private Button btDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d("TAG","onCreate on Profile");
        btDone = (Button) findViewById(R.id.btDone);
        btDone.setOnClickListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Constant.USER);
        int Age = intent.getIntExtra("AGE",0);

        Log.d("TAG",userName);
        Log.d("TAG", Age+"");
        Toast.makeText(this, userName,Toast.LENGTH_LONG).show();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btDone:
                onDone();
                break;
            default:
                break;
        }
    }
    private  void  onDone(){
        Intent intent = new Intent();
        intent. putExtra("PROFILE", "Text from profile");
        setResult(Constant.RESULTCODE, intent);
        finish();
    }
}