package com.victor.coordinatorlayoutdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.victor.coordinatorlayoutdemo.CollapsingActivity;
import com.victor.coordinatorlayoutdemo.R;

/**
 * Created by Victor on 2017/1/23.
 */

public class FoundFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_found, container, false);
        RelativeLayout rlDynamic = (RelativeLayout) view.findViewById(R.id.rl_dynamic);
        rlDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CollapsingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;

    }



}
