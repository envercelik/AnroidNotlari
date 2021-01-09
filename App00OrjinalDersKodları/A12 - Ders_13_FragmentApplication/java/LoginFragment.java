package ders.yasin.fragmentapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {
    EditText etUserName,etPassword;
    Button btnNewUser,btnLogin;
    String trueUserName="Ahmet";
    String truePassword="12345";


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        etUserName= view.findViewById(R.id.et_UserName);
        etPassword=view.findViewById(R.id.et_Password);
        btnLogin=view.findViewById(R.id.btn_Login);
        btnNewUser=view.findViewById(R.id.btn_NewUser);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etUserName.getText().toString();
                String password=etPassword.getText().toString();
                if(userName.equals(trueUserName)&& password.equals(truePassword)){
                    Toast.makeText(getActivity(),"Welcome to our application",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Username or password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterFragment registerFragment=new RegisterFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,registerFragment).commit();
            }
        });

        return view;
    }
}