package com.example.ss5;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter  extends RecyclerView.Adapter {
    private List<Contact> listContact;
    private Activity activity;


    public ContactAdapter(List<Contact> listContact, Activity activity) {
        this.listContact = listContact;
        this.activity = activity;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_contact,parent,false);
        ContactHolder holder = new ContactHolder(view);
        return holder;
    }

    public  class ContactHolder extends RecyclerView.ViewHolder{

        ImageView ivAvatar;
        TextView tvName;
        TextView tvPhone;

        public ContactHolder( @NonNull View itemView) {
            super(itemView);
           ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName =itemView.findViewById(R.id.tvUser) ;
             tvPhone= itemView.findViewById(R.id.tvPhone);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
ContactHolder contactHolder = (ContactHolder) holder;
Contact data = listContact.get(position);
contactHolder.ivAvatar.setImageResource(data.getAvatar());
contactHolder.tvName.setText(data.getName());
contactHolder.tvPhone.setText(data.getPhone());
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
}
