package com.example.ss6recyclerview.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ss6recyclerview.R;
import com.example.ss6recyclerview.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {

    //B1 : data Source
    //B2: Lay out
    Activity activity;
    List<Contact> listData;
    //Step2:
    IOnClickAdapter iOnClickAdapter;

    public ContactAdapter(Activity activity, List<Contact> listData) {
        this.activity = activity;
        this.listData = listData;
    }
    //step 3:

    public  void  registerClick(IOnClickAdapter iClick){
        this.iOnClickAdapter = iClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_contact,parent,false);
        ContactHolder holder = new ContactHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        //B2: set Data
        ContactHolder vh =  (ContactHolder)holder;
        Contact model = listData.get(position);
        vh.ivAvatar.setImageResource(model.getAvatar());
        vh.tvUser.setText(model.getName());
        vh.tvPhone.setText(model.getPhone());

    }

    @Override
    public int getItemCount() {

        return listData.size();
    }
    public  class  ContactHolder extends  RecyclerView.ViewHolder{
        ImageView ivAvatar ;
        TextView tvUser ;
        TextView tvPhone;
        Button btEdit;
        public ContactHolder(@NonNull  View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            btEdit = itemView.findViewById(R.id.btEdit);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ContactAdapter","onClick: " + getAdapterPosition());
                    Contact model = listData.get(getAdapterPosition());
                    Log.d("ContactAdapter","name"+ model.getName());
                    //step4

                    iOnClickAdapter.onClickItem(getAdapterPosition());

                }
            });
            btEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClickAdapter.onClickEdit(getAdapterPosition());
                }
            });


        }
    }

    //step 1: create interface contains action
    public  interface  IOnClickAdapter{
        void onClickEdit( int position);

        void onClickItem(int position);
    }

}
