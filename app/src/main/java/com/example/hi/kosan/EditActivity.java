package com.example.hi.kosan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hi.kosan.Model.PostPutDelPembeli;
import com.example.hi.kosan.Rest.ApiClient;
import com.example.hi.kosan.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText edtId,edtNamaPembeli, edtNoTelpPembeli;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNamaPembeli = (EditText) findViewById(R.id.edtNamaPembeli);
        edtNoTelpPembeli = (EditText) findViewById(R.id.edtNoTelpPembeli);
        Intent mIntent = getIntent();
            edtId.setText(mIntent.getStringExtra("Id"));
            edtId.setTag(edtId.getKeyListener());
            edtId.setKeyListener(null);
            edtNamaPembeli.setText(mIntent.getStringExtra("Nama"));
            edtNoTelpPembeli.setText(mIntent.getStringExtra("No Telp"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
            btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPembeli> updatePembeliCall = mApiInterface.putPembeli(
                        edtId.getText().toString(),
                        edtNamaPembeli.getText().toString(),
                        edtNoTelpPembeli.getText().toString());
                updatePembeliCall.enqueue(new Callback<PostPutDelPembeli>() {
                    @Override
                    public void onResponse(Call<PostPutDelPembeli> call, Response<PostPutDelPembeli> response) {
                        MenuActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPembeli> call, Throwable t) {
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
                    Call<PostPutDelPembeli> deletePembeli = mApiInterface.deletePembeli(edtId.getText().toString());
                    deletePembeli.enqueue(new Callback<PostPutDelPembeli>() {
                        @Override
                        public void onResponse(Call<PostPutDelPembeli> call, Response<PostPutDelPembeli> response) {
                            MenuActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelPembeli> call, Throwable t) {
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
                MenuActivity.ma.refresh();
                finish();
            }
        });
    }
}
