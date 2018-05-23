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

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class SamFragment extends Fragment implements Serializable{
    transient OnFragmentButtonListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;
    }

    public SamFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sam, container, false);

        v.findViewById(R.id.bt_sam1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(7);
            }
        });

        v.findViewById(R.id.bt_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(8);
            }
        });

        return v;
    }




}
