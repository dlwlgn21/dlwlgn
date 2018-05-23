package com.ace.prototypechoiceadventure;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sam3Fragment extends Fragment implements Serializable{
    transient OnFragmentButtonListener listener;
    transient TextView tv_samText3;
    transient Button bt_samButton5, bt_samButton6;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;
    }

    public Sam3Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sam, container, false);

        tv_samText3 = v.findViewById(R.id.tv_sam);
        tv_samText3.setText(R.string.samText3);
        bt_samButton5 = v.findViewById(R.id.bt_sam1);
        bt_samButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(10);
            }
        });
        bt_samButton6 = v.findViewById(R.id.bt_sam2);
        bt_samButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(11);
            }
        });
        return v;
    }




}
