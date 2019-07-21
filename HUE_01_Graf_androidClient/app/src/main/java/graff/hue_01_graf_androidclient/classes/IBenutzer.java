package graff.hue_01_graf_androidclient.classes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface IBenutzer {
     @GET("typFromBenutzer/{mail}")
     Call<List<Reisetyp>> findReisetypFromBenutzer(@Path("mail") String s);
     @GET("reisenFromBenutzer/{mail}")
     Call<List<Reiseveranstaltung>> findReisenFromBenutzer(@Path("mail") String s);
     @GET("allBenutzer")
     Call<List<Benutzer>> findAllBenutzer();



}
