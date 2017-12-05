package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 05/12/2017.
 */

public class Reservasi {
    @SerializedName("id_reservasi")
    private String id_reservasi;
    @SerializedName("nama_kost")
    private String nama_kost;
    @SerializedName("nama_penjual")
    private String nama_penjual;
    @SerializedName("nama_pembeli")
    private String nama_pembeli;

    public Reservasi(){
    }

    public Reservasi(String id_reservasi, String nama_kost, String nama_penjual, String nama_pembeli) {
        this.id_reservasi = id_reservasi;
        this.nama_kost = nama_kost;
        this.nama_penjual = nama_penjual;
        this.nama_pembeli = nama_pembeli;
    }

    public String getId_reservasi() {
        return id_reservasi;
    }

    public void setId_reservasi(String id_reservasi) {
        this.id_reservasi = id_reservasi;
    }

    public String getNama_kost() {
        return nama_kost;
    }

    public void setNama_kost(String nama_kost) {
        this.nama_kost = nama_kost;
    }

    public String getNama_penjual() {
        return nama_penjual;
    }

    public void setNama_penjual(String nama_penjual) {
        this.nama_penjual = nama_penjual;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }
}
