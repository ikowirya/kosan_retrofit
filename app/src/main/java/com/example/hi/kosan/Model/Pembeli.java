package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 28/11/2017.
 */

public class Pembeli {

    @SerializedName("id_pembeli")
    private String id_pembeli;
    @SerializedName("nama_pembeli")
    private String nama_pembeli;
    @SerializedName("notelp_pembeli")
    private String notelp_pembeli;

    public Pembeli(){}
    public Pembeli(String id_pembeli, String nama_pembeli, String notelp_pembeli) {
        this.id_pembeli = id_pembeli;
        this.nama_pembeli = nama_pembeli;
        this.notelp_pembeli = notelp_pembeli;
    }

    public String getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(String id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getNotelp_pembeli() {
        return notelp_pembeli;
    }

    public void setNotelp_pembeli(String notelp_pembeli) {
        this.notelp_pembeli = notelp_pembeli;
    }
}

