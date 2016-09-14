package sheepm.ucclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sheepm.ucclient.R;

/**
 * Created by paomo on 2016/9/14.
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.NormalViewHolder>{

    private List<String> mLists;
    private Context mContext;

    public ContentAdapter(Context context , List<String> list){
        this.mContext = context;
        this.mLists = list;
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_content,parent,false);
        NormalViewHolder holder = new NormalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        String s = mLists.get(position);
        if(!TextUtils.isEmpty(s)){
            holder.mTvName.setText(s);
        }
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder{

        public TextView mTvName;

        public NormalViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_content_name);
        }
    }

}
