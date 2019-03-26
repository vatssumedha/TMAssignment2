package com.tmassigment2.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tmassigment2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sumedha Vats on 26-03-2019.
 */
public class ChildFragment extends Fragment {
    public ChildFragment() {

    }

    @BindView(R.id.imgView)
    ImageView imgView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        Picasso.with(getActivity()).load(bundle.getString("image")).into(imgView);
        return view;
    }
}
