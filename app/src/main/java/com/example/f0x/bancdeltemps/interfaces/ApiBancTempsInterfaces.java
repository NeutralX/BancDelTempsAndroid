package com.example.f0x.bancdeltemps.interfaces;


import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.responses.ResponseGetPacts;
import com.example.f0x.bancdeltemps.responses.ResponseGetPosts;
import com.example.f0x.bancdeltemps.responses.ResponseLogin;
import com.example.f0x.bancdeltemps.responses.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiBancTempsInterfaces {

    @POST("userLoginPost")
    Call<ResponseLogin> doLogin(@Body User user);

    @POST("user")
    Call<ResponseRegister> doRegistre(@Body User user);

    @GET("postsAnd")
    Call<ResponseGetPosts> getPosts();

    @GET("postsTitleAnd")
    Call<ResponseGetPosts> getPostsTitle (@Query("title") String title);

    @GET("pactsAnd/{id}")
    Call<ResponseGetPacts> getPacts(@Path("id")String id);

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
