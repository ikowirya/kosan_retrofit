package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 29/11/2017.
 */

public class Kost {
    @SerializedName("id_kost")
    private String id_kost;
    @SerializedName("nama_kost")
    private String nama_kost;
    @SerializedName("alamat_kost")
    private String alamat_kost;
    @SerializedName("luas_kamar")
    private String luas_kamar;
    @SerializedName("biaya_sewa")
    private String biaya_sewa;

    public Kost(){}
    public Kost(String id_kost, String nama_kost, String alamat_kost, String luas_kamar, String biaya_sewa) {
        this.id_kost = id_kost;
        this.nama_kost = nama_kost;
        this.alamat_kost = alamat_kost;
        this.luas_kamar = luas_kamar;
        this.biaya_sewa = biaya_sewa;
    }
    public String getId_kost() {
        return id_kost;
    }

    public void setId_kost(String id_kost) {
        this.id_kost = id_kost;
    }

    public String getNama_kost() {
        return nama_kost;
    }

    public void setNama_kost(String nama_kost) {
        this.nama_kost = nama_kost;
    }

    public String getAlamat_kost() {
        return alamat_kost;
    }

    public void setAlamat_kost(String alamat_kost) {
        this.alamat_kost = alamat_kost;
    }

    public String getLuas_kamar() {
        return luas_kamar;
    }

    public void setLuas_kamar(String luas_kamar) {
        this.luas_kamar = luas_kamar;
    }

    public String getBiaya_sewa() {
        return biaya_sewa;
    }

    public void setBiaya_sewa(String biaya_sewa) {
        this.biaya_sewa = biaya_sewa;
    }
}
