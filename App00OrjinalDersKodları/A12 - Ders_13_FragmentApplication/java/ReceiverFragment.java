package ders.yasin.fragmentapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReceiverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReceiverFragment extends Fragment {
    TextView tvName;
    String paramName;

    public ReceiverFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ReceiverFragment newInstance(String name) {
        ReceiverFragment fragment = new ReceiverFragment();
        Bundle args = new Bundle();
        args.putString("NAME", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paramName = getArguments().getString("NAME");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_receiver, container, false);
        tvName=view.findViewById(R.id.tv_name);
        tvName.setText(paramName);
        return view;

    }

    public void setName(String name) {
        tvName.setText(name);
    }
}