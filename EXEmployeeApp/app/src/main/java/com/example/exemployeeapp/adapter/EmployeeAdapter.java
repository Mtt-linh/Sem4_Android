package com.example.exemployeeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemployeeapp.R;
import com.example.exemployeeapp.activity.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Employee> list;


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder hd = (EmployeeHolder) holder;
        Employee employeeEntity = list.get(position);
        hd.tvEmployeeName.setText(employeeEntity.employeename);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView tvEmployeeName;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = (TextView) itemView.findViewById(R.id.tvEmployeeName);
        }
    }
    public EmployeeAdapter(Activity activity, List<Employee> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<Employee> list)
    {
        this.list = list;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_list,parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }
}
