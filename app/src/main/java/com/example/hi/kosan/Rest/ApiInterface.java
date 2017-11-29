package com.example.hi.kosan.Rest;

import com.example.hi.kosan.Model.GetKost;
import com.example.hi.kosan.Model.GetPembeli;
import com.example.hi.kosan.Model.PostPutDelKost;
import com.example.hi.kosan.Model.PostPutDelPembeli;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;


/**
 * Created by Hi on 28/11/2017.
 */

public interface ApiInterface {
    @GET("pembeli")
    Call<GetPembeli> getPembeli();
    @FormUrlEncoded
    @POST("pembeli")
    Call<PostPutDelPembeli> postPembeli(@Field("id_pembeli") String id_pembeli,
                                       @Field("nama_pembeli") String nama_pembeli,
                                       @Field("notelp_pembeli") String notelp_pembeli);
    @FormUrlEncoded
    @PUT("pembeli")
    Call<PostPutDelPembeli> putPembeli(@Field("id_pembeli") String id_pembeli,
                                      @Field("nama_pembeli") String nama_pembeli,
                                      @Field("notelp_pembeli") String notelp_pembeli);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pembeli", hasBody = true)
    Call<PostPutDelPembeli> deletePembeli(@Field("id_pembeli") String id_pembeli);

    @GET("kost")
    Call<GetKost> getKost();
    @FormUrlEncoded
    @POST("kost")
    Call<PostPutDelKost> postKost(@Field("id_kost") String id_kost,
                                        @Field("nama_kost") String nama_kost,
                                     @Field("alamat_kost") String alamat_kost,
                                     @Field("luas_kamar") String luas_kamar,
                                        @Field("biaya_sewa") String biaya_sewa);
    @FormUrlEncoded
    @PUT("kost")
    Call<PostPutDelKost> putKost(@Field("id_kost") String id_kost,
                                       @Field("nama_kost") String nama_kost,
                                    @Field("alamat_kost") String alamat_kost,
                                    @Field("luas_kamar") String luas_kamar,
                                       @Field("biaya_sewa") String biaya_sewa);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kost", hasBody = true)
    Call<PostPutDelKost> deleteKost(@Field("id_kost") String id_kost);
}

