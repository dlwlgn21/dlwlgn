package com.ace.prototypechoiceadventure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Dul2Fragment extends Fragment implements Parcelable {
    TextView tv_dul;
    Button bt_dul1, bt_dul2;
    OnFragmentButtonListener listener;

    @SuppressLint("ValidFragment")
    protected Dul2Fragment(Parcel in) {
    }

    public static final Creator<Dul2Fragment> CREATOR = new Creator<Dul2Fragment>() {
        @Override
        public Dul2Fragment createFromParcel(Parcel in) {
            return new Dul2Fragment(in);
        }

        @Override
        public Dul2Fragment[] newArray(int size) {
            return new Dul2Fragment[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
