package com.example.hi.kosan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hi.kosan.Adapter.KostAdapter;
import com.example.hi.kosan.Model.GetKost;
import com.example.hi.kosan.Model.Kost;
import com.example.hi.kosan.Rest.ApiClient;
import com.example.hi.kosan.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuKostActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btIns;
    private Session session;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MenuKostActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kost);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton btIns = (FloatingActionButton) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuKostActivity.this, InsertKostActivity.class));
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewKost);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_kost);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void refresh() {
        Call<GetKost> kostCall = mApiInterface.getKost();
        kostCall.enqueue(new Callback<GetKost>() {
            @Override
            public void onResponse(Call<GetKost> call, Response<GetKost>
                    response) {
                List<Kost> KostList = response.body().getListDataKost();
                Log.d("Retrofit Get", "Jumlah data Kost: " +
                        String.valueOf(KostList.size()));
                mAdapter = new KostAdapter(KostList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetKost> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_kost);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btnLogout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MenuKostActivity.this,LoginActivity.class));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_listsewa) {
            // Handle the camera action
            viewreservasi();
        } else if (id == R.id.nav_datakost) {
            crudkost();
        } else if (id == R.id.nav_datapembeli) {
            crudpembeli();
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_kost);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void viewreservasi(){
        startActivity(new Intent(MenuKostActivity.this,MenuReservasiActivity.class));
        finish();
    }
    private void crudpembeli(){
        startActivity(new Intent(MenuKostActivity.this,MenuActivity.class));
        finish();
    }
    private void crudkost(){
        startActivity(new Intent(MenuKostActivity.this,MenuKostActivity.class));
        finish();
    }
}
