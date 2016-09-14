package sheepm.ucclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sheepm.ucclient.R;
import sheepm.ucclient.adapter.ContentAdapter;

/**
 * Created by paomo on 2016/9/13.
 */
public class MainFragment extends Fragment {

    private ContentAdapter mAdapter;
    private RecyclerView mRvContent;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_view_one,container,false);
        initView();
        return view;
    }

    private void initView(){
        mAdapter = new ContentAdapter(getActivity(),getData());
        mRvContent = (RecyclerView) view.findViewById(R.id.rv_content);
        mRvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvContent.setAdapter(mAdapter);
    }

    private List<String> getData(){
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++){
            list.add("item" + i);
        }
        return list;
    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }
}
