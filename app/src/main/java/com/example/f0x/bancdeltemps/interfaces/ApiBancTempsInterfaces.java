package com.example.f0x.bancdeltemps.interfaces;


import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.responses.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiBancTempsInterfaces {

    @POST("userLoginPost")
    Call<ResponseLogin> doLogin(@Body User user);

//    @GET("averia/lista")
//    Call<ResponseLlistatAveries> getAverias(@Query("X-API-KEY") String key);
//
//    @GET("taller/lista")
//    Call<ResponseLlistatTallers> getTallers(@Query("X-API-KEY") String key);
//
//    @FormUrlEncoded
//    @POST("auth/register")
//    Call<ResponseRegister> doRegister(@Field("nombre") String nombre,
//                                      @Field("email") String email,
//                                      @Field("password") String password);
//
//    @FormUrlEncoded
//    @POST("averia/nueva")
//    Call<ResponseAfegirAveria> afegirAveria(@Field("X-API-KEY") String key,
//                                            @Field("titulo") String titul,
//                                            @Field("descripcion") String descripcio,
//                                            @Field("marca") String marca,
//                                            @Field("modelo") String model);
}
