package com.example.f0x.bancdeltemps.interfaces;


import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.responses.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiBancTempsInterfaces {

    @POST("userLoginPost")
    Call<ResponseLogin> doLogin(@Body User user);

    @POST("user")
    Call<ResponseRegister> doRegistre(@Body User user);

    @GET("postsAnd")
    Call<ResponseGetPosts> getPosts();

    @GET("postsUserAnd/{filtre}")
    Call<ResponseGetPosts> getPostsByUser(@Path("filtre") int filtre);

    //Torna tots els pactes dels que no és autor
    @GET("pactsUserAnd/{userId}")
    Call<ResponseGetPacts> getPactsByUser(@Path("userId") int userId);

    @GET("postsTitleAnd/{title}")
    Call<ResponseGetPosts> getPostsTitle(@Path("title") String title);

    //Torna els pactes del que és autor
    @GET("pactsAnd/{id}")
    Call<ResponseGetPacts> getPacts(@Path("id") int id);

    @GET("categoryId/{nom}")
    Call<ResponseCrearPost> getCategoryId(@Path("nom") String nom);

    @POST("postPost")
    Call<ResponseCrearPost> createPost(@Body Post post);

    //Aconseguir user per ID per a fer un pacte
    @GET("userSi/{id}")
    Call<ResponseLogin> userPerId(@Path("id") int id);
    // @POST("insertReport")
    //Call<ResponseCrearPost> sendReport(@Body Report report);

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
