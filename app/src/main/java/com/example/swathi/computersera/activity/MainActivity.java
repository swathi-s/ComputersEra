package com.example.swathi.computersera.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.adapter.HeaderAdapter;
import com.example.swathi.computersera.model.Header;
import com.example.swathi.computersera.rest.ApiClient;
import com.example.swathi.computersera.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.header_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Header>> call = apiInterface.getHeader();
        call.enqueue(new Callback<List<Header>>() {
            @Override
            public void onResponse(Call<List<Header>> call, Response<List<Header>> response) {

                List<Header> headers = response.body();
                Log.d("response is",response.body().toString());
                recyclerView.setAdapter(new HeaderAdapter(headers,R.layout.list_item_view,getApplicationContext()));
                //List<Header> headers = response.toString();
            }

            @Override
            public void onFailure(Call<List<Header>> call, Throwable t) {

            }
        });
    }



}
