package com.example.f0x.bancdeltemps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.Pact;
import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.classes.Report;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseCrearPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static com.example.f0x.bancdeltemps.MainActivity.GLOBAL_User;

public class RVPactsAdapter extends RecyclerView.Adapter<RVPactsAdapter.PactViewHolder>{

    //Hem de crear una classe interna basada en RecyclerView.ViewHolder.

    public static class PactViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Title;
        TextView Date;
        ImageView CategoryImage;

        PactViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardViewIdPacts);
            Title = itemView.findViewById(R.id.titlePacts);
            Date = itemView.findViewById(R.id.datePacts);
            //CategoryImage = itemView.findViewById(R.id.imageCategoryPacts);
        }
    }

    //Constructor
    List<Pact> pacts;
    Context mContext;
    Boolean aceptats;
    final DateFormat formatw = new SimpleDateFormat("dd-MM-yyyy");
    public RVPactsAdapter(Context mContext,List<Pact> pacts, boolean aceptats){
        this.mContext = mContext;
        this.pacts = pacts;
        this.aceptats = aceptats;
    }

    //S'han de sobreescriure tres mètodes abstractes a ReccylerView.Adapter:

    //1: getItemCount és per a tornar el número d'elements de les dades. En aquest cas criden al size de la llista.
    @Override
    public int getItemCount() {
        return pacts.size();
    }


    //2: onCreativeViewHolder és cridat quan el ViewHolder necessita ser inicialitzat. S'ha d'especificar el Layout que cada element del
    // RecyclerView farà servir. Aquí estem enllaçant el layout CardView a cada item del RecyclerView.
    @Override
    public PactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_pacts_layout, viewGroup, false);
        PactViewHolder pvh = new PactViewHolder(v);
        return pvh;
    }

    //3: onBindViewHolder especifica el contingut de cada element del RV. Aquesta funció és molt similar al
    //getView del adapter del ListView. Aquí és on fiquem els valors al nom, edat i foto de cada CardView.
    @Override
    public void onBindViewHolder(PactViewHolder postViewHolder, final int i) {
        postViewHolder.Title.setText(pacts.get(i).getTitle());
        postViewHolder.Date.setText(pacts.get(i).getDateCreated());
        //postViewHolder.CategoryImage.setImageAlpha(R.drawable.categoria_informatica2);
        //postViewHolder.Brand.setText(bycicles.get(i).brand);
        /*switch ((int) pacts.get(i).getPost().getCategoryIdCategory()) {
            case 1:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_cuinafinal);
                break;
            case 2:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_jardineria);
                break;
            case 4:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icon_bricolatge);
                break;
            case 5:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.categoria_informatica);
                break;
            case 7:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_electronica);
                break;
            case 11:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_esport);
                break;
            case 12:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_mecanica);
                break;
            case 13:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_llar);
                break;
            case 14:
                postViewHolder.CategoryImage.setBackgroundResource(R.drawable.icons_altresfinal);
                break;
        }*/
        postViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aceptats){
                    showAceptatDialog(pacts.get(i));
                }
            }
        });


    }

    public void showAceptatDialog( final Pact p){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Pacte finalitzat?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finalitzarPacte(p);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void finalitzarPacte(Pact p){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mContext.getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        String dateCreated = formatw.format(Calendar.getInstance().getTime());

        Pact pact = new Pact(p.getIdPact(),dateCreated,p.getHours());
        Call<ResponseCrearPost> peticioEnviarReport = apiService.finalitzarPact(pact);

        peticioEnviarReport.enqueue(new Callback<ResponseCrearPost>() {


            @Override
            public void onResponse(Call<ResponseCrearPost> call, Response<ResponseCrearPost> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    String idPost = response.body().getValue().toString();
                    if(idPost != null){
                        Toast.makeText(mContext, "Pacte finalitzat", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<ResponseCrearPost> call, Throwable t) {
                Toast.makeText(mContext, "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
