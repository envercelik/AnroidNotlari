package ders.yasin.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunicationActivity extends AppCompatActivity implements SenderFragment.OnNameSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
        SenderFragment sender=new SenderFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,sender).commit();
    }

    @Override
    public void onSetName(String name) {
        //Statik fragment usage
        ReceiverFragment staticReceiver= (ReceiverFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_reciever);
        staticReceiver.setName(name);

        //Dinamic fragment usage
        ReceiverFragment dinamicReceiver=ReceiverFragment.newInstance(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,dinamicReceiver).commit();


    }
}