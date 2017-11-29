package com.example.hi.kosan.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hi.kosan.EditKostActivity;
import com.example.hi.kosan.Model.Kost;
import com.example.hi.kosan.R;

import java.util.List;

/**
 * Created by Hi on 29/11/2017.
 */

public class KostAdapter  extends RecyclerView.Adapter<KostAdapter.MyViewHolder> {
    List<Kost> mKostList;

    public KostAdapter(List <Kost> KostList) {
        mKostList = KostList;
    }

    @Override
    public KostAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kost_list, parent, false);
        KostAdapter.MyViewHolder mViewHolder = new KostAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (KostAdapter.MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mKostList.get(position).getId_kost());
        holder.mTextViewNama.setText("Nama = " + mKostList.get(position).getNama_kost());
        holder.mTextViewAlamat.setText("Alamat = " + mKostList.get(position).getAlamat_kost());
        holder.mTextViewLuasKamar.setText("Luas Kamar = " + mKostList.get(position).getLuas_kamar());
        holder.mTextViewBiayaSewa.setText("Biaya Sewa= " + mKostList.get(position).getBiaya_sewa());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditKostActivity.class);
                mIntent.putExtra("Id", mKostList.get(position).getId_kost());
                mIntent.putExtra("Nama", mKostList.get(position).getNama_kost());
                mIntent.putExtra("Alamat", mKostList.get(position).getAlamat_kost());
                mIntent.putExtra("Luas Kamar", mKostList.get(position).getLuas_kamar());
                mIntent.putExtra("Biaya Sewa", mKostList.get(position).getBiaya_sewa());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mKostList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewAlamat, mTextViewLuasKamar,mTextViewBiayaSewa;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.id_kost);
            mTextViewNama = (TextView) itemView.findViewById(R.id.nama_kost);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.alamat_kost);
            mTextViewLuasKamar = (TextView) itemView.findViewById(R.id.luas_kamar);
            mTextViewBiayaSewa = (TextView) itemView.findViewById(R.id.biaya_sewa);
        }
    }
}
