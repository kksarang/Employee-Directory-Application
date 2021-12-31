package com.example.whiterabbit.DataBase;

import androidx.room.Database;

import com.example.whiterabbit.API.MyApi;

@Database(entities = {Employee.class} ,  version = 1)

public abstract class AppDatabase {

    public abstract MyApi employeeDao();


}
