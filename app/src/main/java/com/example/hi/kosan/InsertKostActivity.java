package com.example.hi.kosan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hi.kosan.Model.PostPutDelKost;
import com.example.hi.kosan.Rest.ApiClient;
import com.example.hi.kosan.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertKostActivity extends AppCompatActivity {
    EditText edtId,edtNamaKost, edtAlamatKost,edtLuasKamar,edtBiayaSewa;
    Button btInsert, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_kost);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNamaKost = (EditText) findViewById(R.id.edtNamaKost);
        edtAlamatKost = (EditText) findViewById(R.id.edtAlamatKost);
        edtLuasKamar = (EditText) findViewById(R.id.edtLuasKamar);
        edtBiayaSewa = (EditText) findViewById(R.id.edtBiayaSewa);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKost> postKostCall = mApiInterface.postKost(edtId.getText().toString(), edtNamaKost.getText().toString(),edtAlamatKost.getText().toString(),edtLuasKamar.getText().toString(),edtBiayaSewa.getText().toString());
                postKostCall.enqueue(new Callback<PostPutDelKost>() {
                    @Override
                    public void onResponse(Call<PostPutDelKost> call, Response<PostPutDelKost> response) {
                        MenuKostActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKost> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuKostActivity.ma.refresh();
                finish();
            }
        });
    }
}
