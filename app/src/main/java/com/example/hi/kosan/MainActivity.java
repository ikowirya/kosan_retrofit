package com.example.hi.kosan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.hi.kosan.Adapter.ReservasiAdapter;
import com.example.hi.kosan.Model.GetReservasi;
import com.example.hi.kosan.Model.Reservasi;
import com.example.hi.kosan.Rest.ApiClient;
import com.example.hi.kosan.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Session session;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewReservasi);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }
    public void refresh() {
        Call<GetReservasi> reservasiCall = mApiInterface.getReservasi();
        reservasiCall.enqueue(new Callback<GetReservasi>() {
            @Override
            public void onResponse(Call<GetReservasi> call, Response<GetReservasi>
                    response) {
                List<Reservasi> ReservasiList = response.body().getListDataReservasi();
                Log.d("Retrofit Get", "Jumlah data Reservasi: " +
                        String.valueOf(ReservasiList.size()));
                mAdapter = new ReservasiAdapter(ReservasiList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetReservasi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
