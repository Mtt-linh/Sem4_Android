package com.example.exemployeeapp.activity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "employeename")
    public String employeename;

    @ColumnInfo(name = "designation")
    public String designation;

    @ColumnInfo(name = "salary")
    public String salary;
}
