package graff.hue_01_graf_androidclient.Adapter;

import android.util.JsonReader;
import android.util.JsonWriter;

import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.util.Date;

public class DateLongFormatTypeAdapter extends TypeAdapter<Date> {

    @Override
    public void write(com.google.gson.stream.JsonWriter out, Date value) throws IOException {
        if(value != null)
        {
            out.value(value.getTime());
        }
        else out.nullValue();
    }

    @Override
    public Date read(com.google.gson.stream.JsonReader in) throws IOException {
        return new Date(in.nextLong());
    }
}
