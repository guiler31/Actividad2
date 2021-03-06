package com.example.guille.actividad2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.example.guille.milib.BlankFragment;
import com.example.guille.milib.Login;
import com.example.guille.milib.LoginListener;
import com.example.guille.milib.Registro;
import com.example.guille.milib.RegistroListener;

public class Main extends AppCompatActivity {

    public Login login;
    public Registro registro;
    public BlankFragment blankFragment;
    public MainActivityEvents mainActivityEvents;
    public FireBaseAdmin fireBaseAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Login) getSupportFragmentManager().findFragmentById(R.id.fragLogin);
        registro = (Registro) getSupportFragmentManager().findFragmentById(R.id.fragRegistro);
        blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.fragBlanck);

        mainActivityEvents = new MainActivityEvents(this);

        fireBaseAdmin = new FireBaseAdmin(this);
        fireBaseAdmin.setListener(mainActivityEvents);



        login.setListener(mainActivityEvents);
        registro.setListener(mainActivityEvents);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(registro);
        transaction.hide(blankFragment);
        transaction.show(login);

        transaction.commit();

    }
}
class MainActivityEvents implements LoginListener, RegistroListener, FireBaseAdmin.FireBaseAdminListener{

    public Main main;

    public MainActivityEvents(Main main){
        this.main = main;
    }

    //Login
    @Override
    public void OnClickedRegister() {

        FragmentTransaction transaction = this.main.getSupportFragmentManager().beginTransaction();
        transaction.show(this.main.registro);
        transaction.hide(this.main.blankFragment);
        transaction.hide(this.main.login);
        transaction.commit();
    }

    //Login
    @Override
    public void OnClickedLogin(String strUser, String strPass) {
        try {
            this.main.fireBaseAdmin.loginWithEmailPass(strUser, strPass);
        }catch (Exception e){

        }


    }

    //register
    @Override
    public void OnClickCancel() {
        FragmentTransaction transaction = this.main.getSupportFragmentManager().beginTransaction();
        transaction.hide(this.main.registro);
        transaction.hide(this.main.blankFragment);
        transaction.show(this.main.login);
        transaction.commit();

    }

    //register
    @Override
    public void OnClickRegister(String strUser, String strPass) {

            this.main.fireBaseAdmin.regis(strUser, strPass);

            Log.v("firebaseadmin","el resultado es: ");



    }

    @Override
    public void fireBaseAdminUserConnected(boolean blconnected) {
        if(blconnected){
            FragmentTransaction transaction = this.main.getSupportFragmentManager().beginTransaction();
            transaction.hide(this.main.registro);
            transaction.show(this.main.blankFragment);
            transaction.hide(this.main.login);
            transaction.commit();
        }

    }

    @Override
    public void fireBaseAdminUserRegister(boolean blregistered) {

        if(blregistered){
            FragmentTransaction transaction = this.main.getSupportFragmentManager().beginTransaction();
            transaction.hide(this.main.registro);
            transaction.show(this.main.blankFragment);
            transaction.hide(this.main.login);
            transaction.commit();
        }

    }
}