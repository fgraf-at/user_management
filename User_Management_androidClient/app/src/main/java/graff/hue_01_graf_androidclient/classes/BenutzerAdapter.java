package graff.hue_01_graf_androidclient.classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import graff.hue_01_graf_androidclient.Adapter.RecyclerViewAdapter;
import graff.hue_01_graf_androidclient.R;

public class BenutzerAdapter extends RecyclerView.Adapter<BenutzerAdapter.BenutzerViewHolder> {

    private List<Benutzer> lBenutzer;

    public BenutzerAdapter(List<Benutzer> benutzers) {
        lBenutzer = benutzers;
        notifyDataSetChanged();
    }

    public BenutzerAdapter() {
       lBenutzer = new ArrayList<>();
    }

    public BenutzerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_listitem, parent, false);
       return new BenutzerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BenutzerViewHolder holder, int position) {
        Benutzer benutzer = lBenutzer.get(position);
        holder.textViewName.setText(benutzer.getName());
        holder.textViewSurname.setText(benutzer.getSurname());
        holder.textViewMail.setText(benutzer.getEmail());
    }

    @Override
    public int getItemCount() {
        return lBenutzer.size();
    }

    public void setlBenutzers(List<Benutzer> benutzers){
        lBenutzer = benutzers;
        notifyDataSetChanged();
    }
    class BenutzerViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewSurname;
        private  TextView textViewMail;
        public BenutzerViewHolder(View itemView) {
            super(itemView);
           textViewMail = itemView.findViewById(R.id.textViewMail);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewSurname = itemView.findViewById(R.id.textViewSurname);
        }
    }
}
