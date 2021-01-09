package ders.yasin.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        container=findViewById(R.id.container);

        //FragmentManager manager=getSupportFragmentManager();
        //FragmentTransaction transaction=manager.beginTransaction();
        //LoginFragment loginFragment=new LoginFragment();
        //transaction.replace(R.id.container,loginFragment);
        //transaction.commit();

        LoginFragment loginFragment=new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,loginFragment).commit();

    }
}