package com.ace.prototypechoiceadventure;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HanaFragment extends Fragment {
    TextView tv_hana;
    OnFragmentButtonListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;

    }

    public HanaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hana, container, false);
        tv_hana = v.findViewById(R.id.tv_hana);


        v.findViewById(R.id.bt_hana1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(1);
            }
        });
        v.findViewById(R.id.bt_hana2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(2);
            }
        });


        return v;
    }

}
