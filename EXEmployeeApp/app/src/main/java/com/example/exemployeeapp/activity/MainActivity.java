package com.example.exemployeeapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemployeeapp.R;
import com.example.exemployeeapp.adapter.EmployeeAdapter;
import com.example.exemployeeapp.database.DBHelper;
import com.example.exemployeeapp.activity.Employee;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAdd, btUpdate, btDelete;
    EditText edEmployeeName, edDesignation, edSalary;
    DBHelper db;
    EmployeeAdapter employeeAdapter;
    RecyclerView recyclerView;
    List<Employee> listEmp = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmployeeName = findViewById(R.id.edEmployeeName);
        edDesignation = findViewById(R.id.edDesignation);
        edSalary = findViewById(R.id.edSalary);
        btAdd = findViewById(R.id.add);
        btUpdate = findViewById(R.id.update);
        btDelete = findViewById(R.id.delete);
        btAdd.setOnClickListener(this::onClick);
        btUpdate.setOnClickListener(this::onClick);
        btDelete.setOnClickListener(this::onClick);
        initData();
        getAllEmployee();
        employeeAdapter = new EmployeeAdapter(MainActivity.this,listEmp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView = findViewById(R.id.rcListEmployee);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(employeeAdapter);

        db = DBHelper.getAppDatabase(this);

    }
    public void initData()
    {
        Employee employeeEntity = new Employee();
        employeeEntity.employeename = "nguyen van a";
        employeeEntity.designation = "demo";
        employeeEntity.salary = "10000";
        db.employeeDao().insertEmployee(employeeEntity);
    }

    private void updateEmployee(int id){
        Employee em = db.employeeDao().getBookmark(id);
        em.employeename = edEmployeeName.getText().toString();
        em.designation = edEmployeeName.getText().toString();
        em.salary = edSalary.getText().toString();
        db.employeeDao().updateEmployee(em);
    }
    private void deleteEmployee(int id){
        Employee em = db.employeeDao().getBookmark(id);
        db.employeeDao().deleteEmployee(em);
    }
    private void findEmployee(int id){
        Employee em = db.employeeDao().getBookmark(id);
    }
    private void getAllEmployee()
    {
        if (db.employeeDao().getAllBookmark()!=null)
        {
            listEmp = db.employeeDao().getAllBookmark();
            employeeAdapter.reloadData(listEmp);
        }else{
            listEmp = db.employeeDao().getAllBookmark();
        }

    }
    private void insertEmployee()
    {
        Employee em = new Employee();
        em.employeename = edEmployeeName.getText().toString();
        em.designation = edEmployeeName.getText().toString();
        em.salary = edSalary.getText().toString();
        db.employeeDao().insertEmployee(em);

    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add:
                insertEmployee();
                Toast.makeText(this, "Insert success", Toast.LENGTH_LONG).show();
                break;
            case R.id.update:
                break;
            case R.id.delete:
                break;
            default:
                break;
        }
    }
}