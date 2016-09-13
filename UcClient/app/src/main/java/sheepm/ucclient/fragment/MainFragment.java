package sheepm.ucclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sheepm.ucclient.R;

/**
 * Created by paomo on 2016/9/13.
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_view_one,container,false);
        return view;
    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }
}
