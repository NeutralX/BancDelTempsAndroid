package com.example.f0x.bancdeltemps;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageView;
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

import static android.content.Context.SEARCH_SERVICE;


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

        setHasOptionsMenu(true);

        // Sempre s'ah de definir un LayoutManager per poder donar un comportament d'expansió al RecyclerView.
        // Es pot definir un LayoutManager propi o fer servir les subclasses ja predefinides. Per exemple LinearLayoutManager o GridViewLayoutManager
        // que emulen el comportament dels bàsics.

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1);
        rvPosts.setLayoutManager(layoutManager);

        getPosts(view, null);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_posts, menu);
        final MenuItem search = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) search.getActionView();
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getPosts(null, query);
                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                //search.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                    getPosts(null, s);
                return false;
            }
        });
        ImageView closeButton = (ImageView)searchView.findViewById(R.id.search_close_btn);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText et = (EditText) searchView.findViewById(R.id.search_src_text);

                //Clear the text from EditText view
                et.setText("");

                //Clear query
                searchView.setQuery("", false);
                //Collapse the action view
                searchView.onActionViewCollapsed();
                //Collapse the search widget
                search.collapseActionView();
                getPosts(null,null);
            }
        });
        search.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                getPosts(null,null);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //if (id == R.id.action_settings) {
//            return true;
//        }

        return false;
    }

    public void getPosts(View view, String search) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);
        Call<ResponseGetPosts> peticioLlistatPosts = null;
        if(search == null){ peticioLlistatPosts = apiService.getPosts();}
        else {peticioLlistatPosts = apiService.getPostsTitle(search);}

        peticioLlistatPosts.enqueue(new Callback<ResponseGetPosts>() {


            @Override
            public void onResponse(Call<ResponseGetPosts> call, Response<ResponseGetPosts> response) {
                if (response.code()== HttpURLConnection.HTTP_OK){

                    List<Post> posts = response.body().getPosts();
                    RVPostsAdapter postsAdapter = new RVPostsAdapter(getContext(),posts);

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
