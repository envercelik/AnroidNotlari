package com.celik.app23fragmentapplication3;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class ColorFragment extends Fragment {

    RadioGroup radioGroupColor;
    OnColorChangeListener colorChangeListener;



    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentColor = inflater.inflate(R.layout.fragment_color, container, false);
        radioGroupColor = fragmentColor.findViewById(R.id.radio_group_color);


        radioGroupColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radio_button_blue:
                        colorChangeListener.onColorChanged(Color.BLUE);
                        break;

                    case R.id.radio_button_green:
                        colorChangeListener.onColorChanged(Color.GREEN);
                        break;

                    case R.id.radio_button_red:
                        colorChangeListener.onColorChanged(Color.RED);
                        break;
                }
            }
        });


        // Inflate the layout for this fragment
        return fragmentColor;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnColorChangeListener) {
            colorChangeListener = (OnColorChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()+ "must implement OnFragmentInteractionListener");
        }

    }


    @Override
    public void onDetach() {
        super.onDetach();
        colorChangeListener = null;
    }
}