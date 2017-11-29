package com.example.hi.kosan;

import android.content.Intent;
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

public class EditKostActivity extends AppCompatActivity {
    EditText edtId,edtNamaKost, edtAlamatKost,edtLuasKamar,edtBiayaSewa;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kost);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNamaKost = (EditText) findViewById(R.id.edtNamaKost);
        edtAlamatKost = (EditText) findViewById(R.id.edtAlamatKost);
        edtLuasKamar = (EditText) findViewById(R.id.edtLuasKamar);
        edtBiayaSewa = (EditText) findViewById(R.id.edtBiayaSewa);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNamaKost.setText(mIntent.getStringExtra("Nama"));
        edtAlamatKost.setText(mIntent.getStringExtra("Alamat"));
        edtLuasKamar.setText(mIntent.getStringExtra("Luas Kamar"));
        edtBiayaSewa.setText(mIntent.getStringExtra("Biaya Sewa"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKost> updateKostCall = mApiInterface.putKost(
                        edtId.getText().toString(),
                        edtNamaKost.getText().toString(),
                        edtAlamatKost.getText().toString(),
                        edtLuasKamar.getText().toString(),
                        edtBiayaSewa.getText().toString());
                updateKostCall.enqueue(new Callback<PostPutDelKost>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelKost> deleteKost = mApiInterface.deleteKost(edtId.getText().toString());
                    deleteKost.enqueue(new Callback<PostPutDelKost>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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
