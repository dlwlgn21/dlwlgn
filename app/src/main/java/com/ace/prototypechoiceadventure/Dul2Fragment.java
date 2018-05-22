package com.ace.prototypechoiceadventure;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Dul2Fragment extends Fragment {
    TextView tv_dul;
    Button bt_dul1, bt_dul2;
    OnFragmentButtonListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;
    }

    public Dul2Fragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dul, container,false);
        tv_dul = v.findViewById(R.id.tv_dul);
        tv_dul.setText(R.string.dulText2);

        bt_dul1 = v.findViewById(R.id.bt_dul1);
        bt_dul2 = v.findViewById(R.id.bt_dul2);

        bt_dul1.setText(R.string.dulButton3);
        bt_dul2.setText(R.string.dulButton4);

        bt_dul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(5);
            }
        });
        bt_dul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(6);
            }
        });
        return v;
    }
}
