package com.example.listviewcall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick{
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();
    private  ContactAdapter mAdaper;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        mAdaper = new ContactAdapter( listContacts, this);
        mAdaper.registerChildItemClick(this);

        lvContact.setAdapter(mAdaper);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                ContactModel model = listContacts.get(i);
                Toast.makeText(MainActivity.this, model.getName()+":"+ model.getPhone(),Toast.LENGTH_SHORT).show();
            }
        });


        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this,contactModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void initView(){
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName =(TextView) findViewById(R.id.tvName);

    }
    private  void  initData(){

        ContactModel contact = new ContactModel("Nguyen Van Manh","03325325",R.drawable.male02);
        listContacts.add(contact);
        contact = new ContactModel("Tran Hoai Anh","0765432",R.drawable.female01);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van Anh","0765432",R.drawable.female01);
        listContacts.add(contact);
        contact = new ContactModel("Tran Trung Kien","0765432",R.drawable.male02);
        listContacts.add(contact);
        contact = new ContactModel("Hoang Hai Minh","0765432",R.drawable.male01);
        listContacts.add(contact);
        contact = new ContactModel("Hoang Quooc Khanh","0765432",R.drawable.male02);
        listContacts.add(contact);
        contact = new ContactModel("Trinh Kim Anh","0765432",R.drawable.images);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Hai Van","0765432",R.drawable.female01);
        listContacts.add(contact);
        contact = new ContactModel("Doan Ba Hung","0765432",R.drawable.male02);
        listContacts.add(contact);
        contact = new ContactModel("Truong Tan Thanh","0765432",R.drawable.male02);
        listContacts.add(contact);
        contact = new ContactModel("Cung Tuan","0765432",R.drawable.cungtuan);
        listContacts.add(contact);
        contact = new ContactModel("Nham Gia Luan","0765432",R.drawable.gialuan);
        listContacts.add(contact);
        contact = new ContactModel("Truong Triet Han","0765432",R.drawable.triethan);

    }
    @Override
    protected  void  onDestroy(){
        super.onDestroy();
        mAdaper.unRegisterChildItemClick();

    }
    public  void onItemChildClick(int position){}
    ContactModel contact = listContacts.get(position);
    ivUser.setImageResource(contact.getImage());
    tvName.setText(contact.getName());
}