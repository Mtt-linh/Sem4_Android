package com.example.ss9sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ss9sqlite.R;
import com.example.ss9sqlite.database.DBHelper;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        //Insert Data
        insertUser();
        //Get data
        getAlluser();
        //Delete data
        deleteUser();
    }



    private void insertUser() {
        User user = new User(1, "Hoang Linh", "Female", 20);
        String message = db.insertDB(user);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private void getAlluser() {
        List<User> listUser = db.getAllUser();
        for (User user : listUser) {
            Log.d("User", "Name: " + user.getName() + "id" + user.getId() + "Age: " + user.getAge());
        }
    }

    private void updateUser() {
        User user = new User();
        user.setId(3);
        user.setName("Truong Thanh Upadate");
        user.setAge(30);
        String message = db.updateUser(user);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void deleteUser() {
        db.deleteUser(3);
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }
    //xin cap quyen ghi bo nho ngoai
//    private  void permission(){
//        final RxPermissions rxPermissions = new RxPermissions(this);
//        rxPermissions
//                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(granted->{
//                    if (granted){
//                        //true you can accsess
//
//                    }else {
//                        //permiassion denied
//                    }});
//    }

}