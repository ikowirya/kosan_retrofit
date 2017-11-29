package com.example.hi.kosan;

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


public class InsertActivity extends AppCompatActivity {
    EditText edtId,edtNamaPembeli, edtNoTelpPembeli;
    Button btInsert, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNamaPembeli = (EditText) findViewById(R.id.edtNamaPembeli);
        edtNoTelpPembeli = (EditText) findViewById(R.id.edtNoTelpPembeli);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPembeli> postPembeliCall = mApiInterface.postPembeli(edtId.getText().toString(), edtNamaPembeli.getText().toString(),edtNoTelpPembeli.getText().toString());
                postPembeliCall.enqueue(new Callback<PostPutDelPembeli>() {
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
