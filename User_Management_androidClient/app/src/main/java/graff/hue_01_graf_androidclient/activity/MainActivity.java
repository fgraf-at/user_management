package graff.hue_01_graf_androidclient.activity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.util.Date;
import java.util.List;

import graff.hue_01_graf_androidclient.Adapter.DateLongFormatTypeAdapter;
import graff.hue_01_graf_androidclient.Adapter.RecyclerViewAdapter;
import graff.hue_01_graf_androidclient.R;
import graff.hue_01_graf_androidclient.classes.Benutzer;
import graff.hue_01_graf_androidclient.classes.BenutzerAdapter;
import graff.hue_01_graf_androidclient.classes.IBenutzer;
import graff.hue_01_graf_androidclient.classes.Reisetyp;
import graff.hue_01_graf_androidclient.classes.Reiseveranstaltung;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setLenient()
                .serializeNulls()

                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:24612/User_Management_Webservice/web/benutzer/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        IBenutzer iBenutzer = retrofit.create(IBenutzer.class);

        Call<List<Reisetyp>> call = iBenutzer.findReisetypFromBenutzer("tobias.frommhund@gmx.at");




        /*
        call.enqueue(new Callback<List<Reisetyp>>() {
            @Override
            public void onResponse(Call<List<Reisetyp>> call, Response<List<Reisetyp>> response) {
                if (!response.isSuccessful()) {
                    Log.d("call", "not successfull");
                }

                List<Reisetyp> lReise = response.body();
                for (Reisetyp r : lReise) {
                    Log.d("call Reisetyp", r.getBezeichnung());
                }


            }

            @Override
            public void onFailure(Call<List<Reisetyp>> call, Throwable t) {
                Log.d("call", "fehler: " + t.getMessage());
                t.printStackTrace();

            }
        });

        Call<List<Reiseveranstaltung>> call2 = iBenutzer.findReisenFromBenutzer("hagmann.fabian@gmx.net");

        call2.enqueue(new Callback<List<Reiseveranstaltung>>() {
            @Override
            public void onResponse(Call<List<Reiseveranstaltung>> call, Response<List<Reiseveranstaltung>> response) {
                if (!response.isSuccessful()) {
                    Log.d("call", "not successfull");
                }

                List<Reiseveranstaltung> lReise = response.body();
                for (Reiseveranstaltung r : lReise) {
                    Log.d("call Veranstaltung", r.getBeschreibung());
                }


            }

            @Override
            public void onFailure(Call<List<Reiseveranstaltung>> call, Throwable t) {
                Log.d("call", "fehler: " + t.getMessage());
                t.printStackTrace();

            }
        });
*/



        RecyclerView recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final BenutzerAdapter benutzerAdapter = new BenutzerAdapter();
        recyclerView.setAdapter(benutzerAdapter);

        Call<List<Benutzer>> call2 = iBenutzer.findAllBenutzer();
        call2.enqueue(new Callback<List<Benutzer>>() {
            @Override
            public void onResponse(Call<List<Benutzer>> call, Response<List<Benutzer>> response) {
                if(response.isSuccessful()){
                    benutzerAdapter.setlBenutzers(response.body());
                    Log.d("call", "successfull");

                }else{
                    Log.d("call", "not successfull");
                }



            }

            @Override
            public void onFailure(Call<List<Benutzer>> call, Throwable t) {

            }
        });

    }



}
