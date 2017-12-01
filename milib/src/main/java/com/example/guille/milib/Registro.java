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
public class Registro extends Fragment {

    public EditText txtfEmail,txtfPass,txtfRpPass;
    public Button btnRegister, btnCancel;
    public RegistroEvents events;
    public RegistroListener registroListener;

    public Registro() {
        // Required empty public constructor
    }

    public void setListener(RegistroListener registroListener) {
        this.registroListener = registroListener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registro, container, false);

        events = new RegistroEvents(this);
        txtfEmail=v.findViewById(R.id.txtfRegEmail);
        txtfPass=v.findViewById(R.id.txtfRegPassword);
        txtfRpPass=v.findViewById(R.id.txtfRegRpPassword);
        btnCancel.setOnClickListener(events);
        btnRegister.setOnClickListener(events);

        return v;
    }

}

class RegistroEvents implements View.OnClickListener {

    public Registro registro;

    public RegistroEvents(Registro registro) {
        this.registro = registro;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnRegCancel) {
            this.registro.registroListener.OnClickCancel();

        } else if (view.getId() == R.id.btnRegRegister) {
            if (registro.txtfPass.equals(registro.txtfRpPass)){
                this.registro.registroListener.OnClickRegister();
            }

        }
    }

}
