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

    public Login() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        txtfEmail.findViewById(R.id.txtfLogEmail);
        txtfPas.findViewById(R.id.txtfLogPassword);
        btnLog.findViewById(R.id.btnLogSignIn);
        btnReg.findViewById(R.id.btnLogRegister);
        return textView;
    }

}
