package com.example.hi.kosan.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hi.kosan.Model.Reservasi;
import com.example.hi.kosan.R;

import java.util.List;

/**
 * Created by Hi on 05/12/2017.
 */

public class ReservasiAdapter extends RecyclerView.Adapter<ReservasiAdapter.MyViewHolder> {
    List<Reservasi> mReservasiList;

    public ReservasiAdapter(List <Reservasi> ReservasiList) {
        mReservasiList = ReservasiList;
    }

    @Override
    public ReservasiAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservasi_list, parent, false);
        ReservasiAdapter.MyViewHolder mViewHolder = new ReservasiAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (ReservasiAdapter.MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mReservasiList.get(position).getId_reservasi());
        holder.mTextViewNamaKost.setText("Nama Kost = " + mReservasiList.get(position).getNama_kost());
        holder.mTextViewNamaPenjual.setText("Nama Penjual = " + mReservasiList.get(position).getNama_penjual());
        holder.mTextViewNamaPembeli.setText("Nama Pembeli = " + mReservasiList.get(position).getNama_pembeli());
    }

    @Override
    public int getItemCount () {
        return mReservasiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNamaKost, mTextViewNamaPenjual,mTextViewNamaPembeli;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.id_reservasi);
            mTextViewNamaKost = (TextView) itemView.findViewById(R.id.nama_kost);
            mTextViewNamaPenjual = (TextView) itemView.findViewById(R.id.nama_penjual);
            mTextViewNamaPembeli = (TextView) itemView.findViewById(R.id.nama_pembeli);
        }
    }
}
