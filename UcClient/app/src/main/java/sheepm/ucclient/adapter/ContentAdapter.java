package sheepm.ucclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paomo on 2016/9/14.
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.NormalViewHolder>{

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder{

        public NormalViewHolder(View itemView) {
            super(itemView);
        }
    }

}
