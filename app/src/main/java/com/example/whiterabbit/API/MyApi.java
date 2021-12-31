package com.example.whiterabbit.API;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.whiterabbit.DataBase.Employee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


@Dao

public interface MyApi {


    @GET("5d565297300000680030a986")
    Call<ArrayList<ModelClass>> modelCall();

    @Insert
    void insert(Employee employee);

}
