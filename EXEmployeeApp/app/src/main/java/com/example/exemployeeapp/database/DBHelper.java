package com.example.exemployeeapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.exemployeeapp.activity.EmployeeDAO;
import com.example.exemployeeapp.activity.Employee;

@Database(entities = {Employee.class},version = 1)
public abstract class DBHelper extends RoomDatabase {
    private static DBHelper appDatabase;
    public abstract EmployeeDAO employeeDao();

    public static DBHelper getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    DBHelper.class,"Employees").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
