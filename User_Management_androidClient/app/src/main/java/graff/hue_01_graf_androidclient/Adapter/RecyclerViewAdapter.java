package graff.hue_01_graf_androidclient.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewAdapter {
    private static final String TAG = "RecyclerViewAdapter";

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
