package com.example.guille.milib;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    public EditText txtfEmail;
    public EditText txtfPas;
    public Button btnLog;
    public Button btnReg;
    public LoginEvents events;
    public LoginListener listener;


    public void setListener(LoginListener listener) {

        this.listener = listener;
    }

    public Login() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        events = new LoginEvents(this);

        txtfEmail = v.findViewById(R.id.txtfLogEmail);
        txtfPas = v.findViewById(R.id.txtfLogPassword);

        btnLog = v.findViewById(R.id.btnLogSignIn);
        btnReg = v.findViewById(R.id.btnLogRegister);

        btnReg.setOnClickListener(events);
        btnLog.setOnClickListener(events);

        return v;
    }




}
class LoginEvents implements View.OnClickListener{

    public Login login;

    public LoginEvents(Login login){

        this.login = login;

    }


    public void onClick(View view) {
        if (view.getId() == R.id.btnLogRegister) {
            this.login.listener.OnClickedRegister();

        } else if (view.getId() == R.id.btnLogSignIn) {
            this.login.listener.OnClickedLogin();
        }
    }

}
