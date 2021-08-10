package com.example.apiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    NestedScrollView scrollView;
    RecyclerView recyclerView ;
    Adaptor adapter;
    RecyclerView.LayoutManager mLayoutManager;
    int mPage =0;
    int mLimit =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<item> list = new ArrayList<item>();
        scrollView = findViewById(R.id.scrollView);

        recyclerView = findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new Adaptor(list,getApplicationContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        getData(mPage , mLimit);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
                    mPage++;
                    getData(mPage , mLimit);

                }
            }
        });

    }

    public void getData(int page , int limit){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<ItemList> call = jsonPlaceHolderApi.getItem("created:>2017-10-22" ,"stargazers_count","desc" ,page,limit);
        call.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                if (!response.isSuccessful()){
                    Log.e("TAG", "onResponse: "+response.body() );
                    Toast.makeText(MainActivity.this, "not successful", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_SHORT).show();
                ItemList mlist = response.body();
                assert mlist != null;
                adapter = new Adaptor(mlist.getItems(),getApplicationContext());
                recyclerView.setAdapter(adapter);
                scrollView.scrollTo(0,0);
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {

                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });

    }
}