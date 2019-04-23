package com.example.f0x.bancdeltemps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseGetPosts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;
import java.util.List;


public class PostsFragment extends Fragment {

    List<Post> posts;
    RecyclerView rvPosts;

    public PostsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        // Inflate the layout for this fragment
        rvPosts = (RecyclerView) view.findViewById(R.id.RecViewPosts);

        //Si el tamany del RecyclerView no canvia:
        rvPosts.setHasFixedSize(true);

        // Sempre s'ah de definir un LayoutManager per poder donar un comportament d'expansió al RecyclerView.
        // Es pot definir un LayoutManager propi o fer servir les subclasses ja predefinides. Per exemple LinearLayoutManager o GridViewLayoutManager
        // que emulen el comportament dels bàsics.

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1);
        rvPosts.setLayoutManager(layoutManager);

        getPosts(view);
        return view;
    }

    public void getPosts(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        Call<ResponseGetPosts> peticioLlistatPosts = apiService.getPosts();

        peticioLlistatPosts.enqueue(new Callback<ResponseGetPosts>() {


            @Override
            public void onResponse(Call<ResponseGetPosts> call, Response<ResponseGetPosts> response) {
                if (response.code()== HttpURLConnection.HTTP_OK){

                    List<Post> posts = response.body().getPosts();
                    RVPostsAdapter postsAdapter = new RVPostsAdapter(posts);

                    rvPosts.setAdapter(postsAdapter);

                    postsAdapter.notifyDataSetChanged();

                }
            }
            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<ResponseGetPosts> call, Throwable t) {
                Toast.makeText(getActivity(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
