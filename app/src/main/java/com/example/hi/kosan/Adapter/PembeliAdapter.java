package com.example.hi.kosan.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hi.kosan.EditActivity;
import com.example.hi.kosan.Model.Pembeli;
import com.example.hi.kosan.R;

import java.util.List;

/**
 * Created by Hi on 28/11/2017.
 */

public class PembeliAdapter extends RecyclerView.Adapter<PembeliAdapter.MyViewHolder> {
    List<Pembeli> mPembeliList;

    public PembeliAdapter(List <Pembeli> PembeliList) {
        mPembeliList = PembeliList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pembeli_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mPembeliList.get(position).getId_pembeli());
        holder.mTextViewNama.setText("Nama = " + mPembeliList.get(position).getNama_pembeli());
        holder.mTextViewNomor.setText("No Telp = " + mPembeliList.get(position).getNotelp_pembeli());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mPembeliList.get(position).getId_pembeli());
                mIntent.putExtra("Nama", mPembeliList.get(position).getNama_pembeli());
                mIntent.putExtra("No Telp", mPembeliList.get(position).getNotelp_pembeli());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPembeliList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.id_pembeli);
            mTextViewNama = (TextView) itemView.findViewById(R.id.nama_pembeli);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.notelp_pembeli);
        }
    }
}
