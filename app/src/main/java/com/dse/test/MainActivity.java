package com.dse.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener{
    private EditText etUsername, etPass;
    private CheckBox rem_userpass;
    private Button button;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (etUsername.length()==0){
                    etUsername.setError("please enter your name here");
                } else if (etPass.length()==0){
                    etPass.setError("please enter password");

                } else
                {
                    openActivity2();
                }

            }
        });


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        etUsername = (EditText)findViewById(R.id.username);
        etPass = (EditText)findViewById(R.id.pass);
        rem_userpass = (CheckBox)findViewById(R.id.checkBox);

        if(sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rem_userpass.setChecked(true);
        else
            rem_userpass.setChecked(false);

        etUsername.setText(sharedPreferences.getString(KEY_USERNAME,""));
        etPass.setText(sharedPreferences.getString(KEY_PASS,""));

        etUsername.addTextChangedListener(this);
        etPass.addTextChangedListener(this);
        rem_userpass.setOnCheckedChangeListener(this);
    }

    public void openActivity2(){


            Intent intent = new Intent(this,Panel.class);
            startActivity(intent);


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }

    private void managePrefs(){
        if(rem_userpass.isChecked()){
            editor.putString(KEY_USERNAME, etUsername.getText().toString().trim());
            editor.putString(KEY_PASS, etPass.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        }else{
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS);//editor.putString(KEY_PASS,"");
            editor.remove(KEY_USERNAME);//editor.putString(KEY_USERNAME, "");
            editor.apply();
        }
    }



    }

