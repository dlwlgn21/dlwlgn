package com.ace.prototypechoiceadventure;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DulFragment extends Fragment implements Parcelable {
    OnFragmentButtonListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentButtonListener) context;
    }

    public DulFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    protected DulFragment(Parcel in) {
    }

    public static final Creator<DulFragment> CREATOR = new Creator<DulFragment>() {
        @Override
        public DulFragment createFromParcel(Parcel in) {
            return new DulFragment(in);
        }

        @Override
        public DulFragment[] newArray(int size) {
            return new DulFragment[size];
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dul, container, false);
        v.findViewById(R.id.bt_dul1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(3);
            }
        });
        v.findViewById(R.id.bt_dul2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentButtonClicked(4);
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
