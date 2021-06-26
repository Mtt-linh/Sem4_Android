package com.example.exemployeeapp.activity;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.exemployeeapp.activity.Employee;

import static androidx.room.OnConflictStrategy.REPLACE;


import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert(onConflict = REPLACE)
    void insertEmployee(Employee employeeEntity);

    @Update
    void updateEmployee(Employee employeeEntity);

    @Delete
    void deleteEmployee(Employee employeeEntity);

    @Query("SELECT * FROM Employee")
    List<Employee> getAllBookmark();

    @Query("SELECT * FROM Employee WHERE id = :id")
    Employee getBookmark(int id);

    @Query("DELETE  FROM Employee")
    void deleteAll();
}
