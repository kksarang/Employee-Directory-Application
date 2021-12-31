package com.example.whiterabbit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.whiterabbit.API.ModelClass;
import com.example.whiterabbit.API.MyApi;
import com.example.whiterabbit.Adapter.MyAdapter;
import com.example.whiterabbit.DataBase.DatabaseClient;
import com.example.whiterabbit.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {


    private RecyclerView recyclerView1;
    private MyApi myApi;
    private ArrayList<ModelClass> modelArrayList;
    private String BaseUrl = "http://www.mocky.io/v2/";
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView1 = findViewById(R.id.recycle);
        modelArrayList = new ArrayList<>();

        viewJsonData();

        fetchfromRoom();



    }

    private void fetchfromRoom() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                Call<ArrayList<ModelClass>> employeeList = DatabaseClient.getInstance(MainActivity2.this)
                        .getAppDatabase().employeeDao().modelCall();
                modelArrayList.clear();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
        thread.start();

    }

    private void viewJsonData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        myApi = retrofit.create(MyApi.class);

        Call<ArrayList<ModelClass>> arrayListCall = myApi.modelCall();

        arrayListCall.enqueue(new Callback<ArrayList<ModelClass>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelClass>> call, Response<ArrayList<ModelClass>> response) {
                modelArrayList = response.body();

                int i = 0;

                for (i = 0; i < modelArrayList.size(); i++) {
                    MyAdapter myAdapter = new MyAdapter(modelArrayList, MainActivity2.this);

                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity2.this,
                            RecyclerView.VERTICAL, false);

                    recyclerView1.setLayoutManager(manager);

                    recyclerView1.setAdapter(myAdapter);

                    recyclerView1.setHasFixedSize(true);
                    recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity2.this));


                }
            }

            @Override
            public void onFailure(Call<ArrayList<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }


    }