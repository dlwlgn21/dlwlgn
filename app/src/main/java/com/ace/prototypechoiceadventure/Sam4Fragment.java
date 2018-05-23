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
public class Sam4Fragment extends Fragment implements Serializable{
    transient OnFragmentButtonListener listener;
    transient TextView tv_samText4;
    transient Button bt_samButton7, bt_samButton8;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;
    }

    public Sam4Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sam, container, false);

        tv_samText4 = v.findViewById(R.id.tv_sam);
        tv_samText4.setText(R.string.samText4);
        bt_samButton7 = v.findViewById(R.id.bt_sam1);
        bt_samButton7.setText(R.string.samButton7);
        bt_samButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(12);
            }
        });
        bt_samButton8 = v.findViewById(R.id.bt_sam2);
        bt_samButton8.setText(R.string.samButton8);
        bt_samButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(13);
            }
        });
        return v;
    }




}
