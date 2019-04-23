package com.example.f0x.bancdeltemps;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVPostsAdapter extends RecyclerView.Adapter<RVPostsAdapter.PostViewHolder>{

    //Hem de crear una classe interna basada en RecyclerView.ViewHolder.

    public static class PostViewHolder extends RecyclerView.ViewHolder {
//        CardView cv;
//        TextView Name;
//        TextView Brand;
//        ImageView Photo;

        PostViewHolder(View itemView) {
            super(itemView);
//            cv = itemView.findViewById(R.id.cardViewId);
//            Name = itemView.findViewById(R.id.name);
//            Photo = itemView.findViewById(R.id.image);
//            Brand = itemView.findViewById(R.id.brand);
        }
    }

    //Constructor
    List<Post> posts;

    public RVPostsAdapter(List<Post> posts){
        this.posts = posts;
    }

    //S'han de sobreescriure tres mètodes abstractes a ReccylerView.Adapter:

    //1: getItemCount és per a tornar el número d'elements de les dades. En aquest cas criden al size de la llista.
    @Override
    public int getItemCount() {
        return posts.size();
    }


    //2: onCreativeViewHolder és cridat quan el ViewHolder necessita ser inicialitzat. S'ha d'especificar el Layout que cada element del
    // RecyclerView farà servir. Aquí estem enllaçant el layout CardView a cada item del RecyclerView.
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_posts_layout, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    //3: onBindViewHolder especifica el contingut de cada element del RV. Aquesta funció és molt similar al
    //getView del adapter del ListView. Aquí és on fiquem els valors al nom, edat i foto de cada CardView.
    @Override
    public void onBindViewHolder(PostViewHolder bycicleViewHolder, int i) {
//        bycicleViewHolder.Name.setText(bycicles.get(i).name);
//
//        bycicleViewHolder.Brand.setText(bycicles.get(i).brand);
//
//        bycicleViewHolder.Photo.setImageResource(bycicles.get(i).photoId);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
