package ders.yasin.fragmentapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;


public class ColorFragment extends Fragment {
    RadioGroup rgGroup;
    OnColorChangeListener colorListener;

    public ColorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_color, container, false);
        rgGroup=v.findViewById(R.id.rg_Color);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radiobutton) {
                switch (radiobutton){
                    case R.id.rb_red: colorListener.onColorChange("RED"); break;
                    case R.id.rb_blue: colorListener.onColorChange("BLUE"); break;
                    case R.id.rb_green: colorListener.onColorChange("GREEN"); break;
                }


            }
        });
        return v;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnColorChangeListener) {
            colorListener = (OnColorChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        colorListener = null;
    }

    public interface OnColorChangeListener{
        void onColorChange(String color);
    }
}